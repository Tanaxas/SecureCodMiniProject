package com.bmt.Tanaka.repositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmt.Tanaka.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    public AppUser findByRegNumber(String regNumber);

}
