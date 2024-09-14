package com.userservice.service;

import com.userservice.dao.UserRepository;
import com.userservice.entity.User;
import com.userservice.exception.UserCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    KafkaProducerService kafkaProducerService;
    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user)throws UserCreationException {
        userRepository.save(user);
        logger.info("[UserService-createUser]:" , "User created successfully");
        kafkaProducerService.sendMessage(user);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByNameOrCity(String firstName, String lastName, String city) {
        return userRepository.findByFirstNameOrLastNameOrCity(firstName,lastName,city);
    }
}
