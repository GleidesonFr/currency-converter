package com.spring.currency_converter.services.interfaces;

import java.util.Collection;
import java.util.UUID;

import com.spring.currency_converter.dtos.HistoryRecordDTO;
import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.models.UserModel;

public interface HistoryService {
    
    public void createHistory(HistoryRecordDTO historyModelDTO);
    public void deleteHistories();
    public HistoryModel getHistory(UUID id);
    public Collection<HistoryModel> getHistories();
    public UserModel getUser();
}
