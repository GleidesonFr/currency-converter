package com.spring.currency_converter.services;

import java.io.IOException;
import java.time.LocalDateTime;
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

    @Autowired
    private MonetaryServiceImpl monetaryServiceImpl;

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
    public HistoryModel createHistory(UUID id, HistoryRecordDTO historyRecordDTO) throws IOException {
        HistoryModel historyModel = new HistoryModel();
        historyModel.setUser(userServiceImpl.getUser(id));
        historyModel.setTime(LocalDateTime.now());
        historyModel.setTo_currency_value(monetaryServiceImpl.convertMoney(historyRecordDTO.from_currency_symbol(), historyRecordDTO.from_currency_value(), historyRecordDTO.to_currency_symbol()));
        BeanUtils.copyProperties(historyRecordDTO, historyModel);
        historyRepository.save(historyModel);
        return historyModel;
    }
    
}
