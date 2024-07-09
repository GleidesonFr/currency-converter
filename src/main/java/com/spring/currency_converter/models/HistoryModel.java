package com.spring.currency_converter.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = HistoryModel.TABLE)
public class HistoryModel extends RepresentationModel<HistoryModel> implements Serializable{

    public static final String TABLE = "tb_history";
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_operation;
    private String from_currency_symbol;
    private double from_currency_value;
    private String to_currency_symbol;
    private double to_currency_value;

    @ManyToOne
    @JoinColumn(name = "id_user")
    public UserModel user;

    public String getFrom_currenc_symbol() {
        return from_currency_symbol;
    }

    public void setFrom_currency_symbol(String from_currency_symbol) {
        this.from_currency_symbol = from_currency_symbol;
    }

    public double getFrom_currency_value() {
        return from_currency_value;
    }

    public void setFrom_currency_value(double from_currency_value) {
        this.from_currency_value = from_currency_value;
    }

    public UUID getId_operation() {
        return id_operation;
    }

    public void setId_operation(UUID id_operation) {
        this.id_operation = id_operation;
    }

    public String getTo_currency_symbol() {
        return to_currency_symbol;
    }

    public void setTo_currency_symbol(String to_currency_symbol) {
        this.to_currency_symbol = to_currency_symbol;
    }

    public double getTo_currency_value() {
        return to_currency_value;
    }

    public void setTo_currency_value(double to_currency_value) {
        this.to_currency_value = to_currency_value;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
    
