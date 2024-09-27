package com.spring.currency_converter.models;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = UserModel.TABLE)
public class UserModel extends RepresentationModel<UserModel> implements UserDetails{
    
    public static final String TABLE = "tb_user";
    @SuppressWarnings("unused")
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonProperty("username")
    private String name;

    private String email;
    
    @JsonProperty("password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<HistoryModel> historyModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<HistoryModel> getHistoryModel() {
        return historyModel;
    }

    public void setHistoryModel(List<HistoryModel> historyModel) {
        this.historyModel = historyModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }

    public boolean isAccountNonExpired(){
        return true;
    }

    public boolean isAccountNonLocked(){
        return true;
    }

    public boolean isCredentialsNonExpired(){
        return true;
    }

    public boolean isEnabled(){
        return true;
    }
}
