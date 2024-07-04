package com.spring.currency_converter.services.interfaces;

import java.util.Collection;
import java.util.UUID;

import com.spring.currency_converter.models.HistoryModel;

public interface HistoryService {
    
    public void createHistory(HistoryModel historyModel);
    public void deleteHistories();
    public HistoryModel getHistory(UUID id);
    public Collection<HistoryModel> getHistories();
}
