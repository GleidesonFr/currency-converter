package com.spring.currency_converter.controllers;

import java.util.List;
import java.util.UUID;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.HistoryRecordDTO;
import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.services.HistoryServiceImpl;
import com.spring.currency_converter.services.MonetaryServiceImpl;

import jakarta.validation.Valid;

@RestController
public class HistoryController {
    
    @Autowired
    PagedResourcesAssembler<HistoryModel> assembler;

    @Autowired
    MonetaryServiceImpl monetaryServiceImpl;

    @Autowired
    private HistoryServiceImpl historyServiceImpl;

    @GetMapping("/{id}/in/currency-converter")
    public ResponseEntity<PagedModel<EntityModel<HistoryModel>>> getAllHistories(@PathVariable("id") UUID id, @RequestParam(value = "page", defaultValue = "0") Integer page, 
    @RequestParam(value = "size", defaultValue = "5") Integer size, @RequestParam(value = "orderBy", defaultValue = "time") String orderBy, @RequestParam(
    value = "direction", defaultValue = "DESC") String direction){
        Page<HistoryModel> historyModels = historyServiceImpl.getHistories(page, size, orderBy, direction);

        return ResponseEntity.ok(assembler.toModel(historyModels));
    }

    @PostMapping("/{id}/in/currency-converter")
    
    public ResponseEntity<HistoryModel> createHistory(@PathVariable("id") UUID id, @RequestBody @Valid HistoryRecordDTO historyRecordDTO){
        HistoryModel historyModel = historyServiceImpl.createHistory(id, historyRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(historyModel);
    }

    @DeleteMapping("/{id}/in/currency-converter")
    public ResponseEntity<Object> deleteAllHistories(@PathVariable(value = "id")UUID id){
        historyServiceImpl.deleteHistories();
        return ResponseEntity.status(HttpStatus.OK).body("All histories has been delected");
    }
}
