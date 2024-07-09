package com.spring.currency_converter.services;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
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
        historyRepository.deleteAll();
    }

    @Override
    public HistoryModel getHistory(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }

    @Override
    public Collection<HistoryModel> getHistories() {
        List<HistoryModel> histories = historyRepository.findAll();
        return histories;
    }

    @Override
    public UserModel getUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public void createHistory(HistoryRecordDTO historyModelDTO) {
        HistoryModel historyModel = new HistoryModel();
        BeanUtils.copyProperties(historyModelDTO, historyModel);
        historyRepository.save(historyModel);
    }
    
}
