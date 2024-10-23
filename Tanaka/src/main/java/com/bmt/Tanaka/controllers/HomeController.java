package com.bmt.Tanaka.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }

    @GetMapping("/contract")
    public String contact(){
        return "contact";
    }

}