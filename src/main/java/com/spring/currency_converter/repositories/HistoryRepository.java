package com.spring.currency_converter.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.models.UserModel;

import java.util.List;


@Repository
public interface HistoryRepository extends JpaRepository<HistoryModel, UUID>{
    
    List<HistoryModel> findByUser(UserModel user);
}
