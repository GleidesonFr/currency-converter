package com.spring.currency_converter.services;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.currency_converter.dtos.HistoryRecordDTO;
import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.models.UserModel;
import com.spring.currency_converter.repositories.HistoryRepository;
import com.spring.currency_converter.services.interfaces.HistoryService;

public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void deleteHistories() {
        
    }

    @Override
    public HistoryModel getHistory(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }

    @Override
    public Collection<HistoryModel> getHistories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistories'");
    }

    @Override
    public UserModel getUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public void createHistory(HistoryRecordDTO historyModelDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createHistory'");
    }
    
}
