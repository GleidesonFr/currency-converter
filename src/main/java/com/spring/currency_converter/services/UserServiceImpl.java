package com.spring.currency_converter.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.currency_converter.dtos.UserRecordDTO;
import com.spring.currency_converter.exceptions.EmailAlreadyExistsException;
import com.spring.currency_converter.exceptions.EmailNotValidException;
import com.spring.currency_converter.exceptions.UserAlreadyExistsException;
import com.spring.currency_converter.exceptions.UserNotFoundException;
import com.spring.currency_converter.models.HistoryModel;
import com.spring.currency_converter.models.UserModel;
import com.spring.currency_converter.repositories.HistoryRepository;
import com.spring.currency_converter.repositories.UserRepository;
import com.spring.currency_converter.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void createUser(UserRecordDTO userRecordDTO) {
        userValidation(userRecordDTO);
        Optional<UserModel> user = userRepository.findByName(userRecordDTO.name());
        if(user.isEmpty()){
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(userRecordDTO, userModel);
            userRepository.save(userModel);
        }else{
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public UserModel updateUser(UserRecordDTO userRecordDTO) {
        UserModel user = getUser(userRecordDTO.name(), userRecordDTO.password());
        BeanUtils.copyProperties(userRecordDTO, user);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(String username, String password) {
        UserModel user = getUser(username, password);
        userRepository.delete(user);
    }

    @Override
    public UserModel getUser(String username, String password) {
        UserModel userModel = this.userRepository.findByName(username).orElseThrow(UserNotFoundException::new);
        if(userModel.getPassword().equals(password)){
            return userModel;
        }else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserModel getUser(UUID id) {
        UserModel userModel = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userModel;
    }

    @Override
    public List<HistoryModel> getHistories(UUID id) {
        UserModel user = getUser(id);
        List<HistoryModel> historyModels = historyRepository.findByUser(user);
        return historyModels;
    }

    private void userValidation(UserRecordDTO userRecordDTO){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        
        if(!Pattern.compile(regexPattern).matcher(userRecordDTO.email()).matches()){
            throw new EmailNotValidException();
        }else{
            Optional<UserModel> user = userRepository.findByEmail(userRecordDTO.email());
            if(!user.isEmpty()){
                throw new EmailAlreadyExistsException();
            }
        }
    }
}