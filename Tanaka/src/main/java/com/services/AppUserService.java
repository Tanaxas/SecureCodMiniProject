package com.services;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.bmt.Tanaka.models.AppUser;
import com.bmt.Tanaka.repositoryPackage.AppUserRepository;

@Service
public class AppUserService implements UserDetailsService{
    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String regNumber) throws UsernameNotFoundException{
        AppUser appUser = repo.findByRegNumber(regNumber);

        if (appUser != null){
            var springUser = User.withUsername(appUser.getRegNumber())
                    .password(appUser.getPassword())
                    .roles(appUser.getRole())
                    .build();
            return springUser;

        }
        return null;
        
    }

}
