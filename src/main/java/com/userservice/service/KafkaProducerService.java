package com.userservice.service;

import com.userservice.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    KafkaTemplate<String, User> kafkatemplate;

    public void sendMessage(User user){
        logger.info("[KafkaProducerService-sendMessage]:" , "User event posted to kafka");
        // commenting this , it will look kafka producer server
       // kafkatemplate.send("user-events", user);
    }



}
