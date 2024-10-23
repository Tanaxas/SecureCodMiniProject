package com.bmt.Tanaka.controllers;

import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;


import com.bmt.Tanaka.models.AppUser;
import com.bmt.Tanaka.models.RegisterDto;
import com.bmt.Tanaka.repositoryPackage.AppUserRepository;

import jakarta.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    private AppUserRepository repo;

    // Handles GET requests to the "/signup" endpoint
    @GetMapping("/signup")
    public String signup(Model model){
        RegisterDto registerDto = new RegisterDto();
        // Add the RegisterDto object to the model for use in the view
        model.addAttribute(registerDto);
        model.addAttribute("success", false);
        return "signup";
    }

    // Add the RegisterDto object to the model for use in the view
    @PostMapping("/signup")
    public String signup(
            Model model,
            @Valid @ModelAttribute RegisterDto registerDto,// Binds form data to RegisterDto and validates it
            BindingResult result
            ){
        // Check if the password and confirm password fields match
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
            result.addError(
                    new FieldError("registerDto", "confirmPassword", "Password and Confirm Password do not match")  
            );
        }
        //AppUser appUser = repo.findByRegNumber(registerDto.RegNumber());
        //if(appUser !=null){
        //    result.addError(
        //            new FieldError("registerDto", "regNum"
        //                    , "Registration Number already exists")
        //    );
        //}

        // If there are validation errors, return to the signup view
        if(result.hasErrors()){
            return "signup";
        }

        try{
            //create account
            var bCryptEncoder = new BCryptPasswordEncoder(); // Create a password encoder
            
            AppUser newUser = new AppUser();
            newUser.setFirstName(registerDto.getFirstName());
            newUser.setLastName(registerDto.getLastName());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone(registerDto.getPhone());
            newUser.setAddress(registerDto.getAddress());
            newUser.setRole("Student");
            newUser.setDepartment("ISA");
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword())); //encode the password

            // Save the new user to the repository
            repo.save(newUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);
        }
        catch(Exception ex){
            result.addError(
                    new FieldError("registerDto", "firstName" , ex.getMessage())
            );
        }

        return "signup";
    }

}
