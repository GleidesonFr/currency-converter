package com.spring.currency_converter.services.interfaces;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.spring.currency_converter.dtos.HistoryRecordDTO;
import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.models.UserModel;

public interface HistoryService {
    
    public HistoryModel createHistory(HistoryRecordDTO historyModelDTO);
    public void deleteHistories();
    public HistoryModel getHistory(LocalDateTime time);
    public Page<HistoryModel> getHistories(Integer page, Integer size, String orderBy, String direction);
    public UserModel getUser(LocalDateTime time);
}
