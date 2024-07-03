package com.spring.currency_converter.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.currency_converter.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{
    
}