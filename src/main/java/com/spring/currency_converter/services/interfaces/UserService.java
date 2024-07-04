package com.spring.currency_converter.services.interfaces;

import java.util.Collection;
import java.util.UUID;

import com.spring.currency_converter.dtos.UserRecordDTO;
import com.spring.currency_converter.models.UserModel;

public interface UserService {
    
    public void createUser(UserRecordDTO userRecordDTO);
    public void updateUser(UUID id, UserRecordDTO userRecordDTO);
    public void deleteUser(UUID id);
    public UserModel getUser(UUID id);
    public Collection<UserModel> getUsers();
}
