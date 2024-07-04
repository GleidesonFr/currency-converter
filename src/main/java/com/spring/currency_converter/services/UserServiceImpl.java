package com.spring.currency_converter.services;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.currency_converter.dtos.UserRecordDTO;
import com.spring.currency_converter.models.UserModel;
import com.spring.currency_converter.repositories.UserRepository;
import com.spring.currency_converter.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(UserRecordDTO userRecordDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public void updateUser(UUID id, UserRecordDTO userRecordDTO
    ) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserModel getUser(UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public Collection<UserModel> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }
    
}
