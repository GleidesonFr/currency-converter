package com.spring.currency_converter.services;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.currency_converter.dtos.HistoryRecordDTO;
import com.spring.currency_converter.exceptions.HistoryNotFoundException;
import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.models.UserModel;
import com.spring.currency_converter.repositories.HistoryRepository;
import com.spring.currency_converter.services.interfaces.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public void deleteHistories() {
        historyRepository.deleteAll();
    }

    @Override
    public HistoryModel getHistory(LocalDateTime time) {
       Optional<HistoryModel> historyModel = historyRepository.findByTime(time);
       if(historyModel.isEmpty()){
            throw new HistoryNotFoundException();
       }else{
        return historyModel.get();
       }
    }

    @Override
    public Page<HistoryModel> getHistories(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        Page<HistoryModel> histories = historyRepository.findAll(pageRequest);
        return histories;
    }

    @Override
    public UserModel getUser(LocalDateTime time) {
        Optional<HistoryModel> historyModel = historyRepository.findByTime(time);
        if(historyModel.isEmpty()){
            throw new HistoryNotFoundException();
        }else{
            return historyModel.get().getUser();
        }
    }

    @Override
    public HistoryModel createHistory(UUID id, HistoryRecordDTO historyModelDTO) {
        HistoryModel historyModel = new HistoryModel();
        historyModel.setUser(userServiceImpl.getUser(id));
        historyModel.setTime(LocalDateTime.now());
        BeanUtils.copyProperties(historyModelDTO, historyModel);
        historyRepository.save(historyModel);
        return historyModel;
    }
    
}
