package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.exception.UserCreationException;
import com.userservice.exception.UserNotFoundException;
import com.userservice.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController("/userService")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    IUserService userService;

    @PostMapping(value="/v1/user", consumes = "application/json" , produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user)  throws UserCreationException {
        logger.info("[createUser] RequestBody: %s" , user.getFirst_name());
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping(value="/v1/user",produces = "application/json")
    public ResponseEntity<?> getUser(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("city") String city)  throws UserNotFoundException {
        List<User> users = new ArrayList<>();
       if(firstName != null || lastName != null || city != null) {
           users=userService.getUserByNameOrCity(firstName,lastName,city);
       } else {
           users=userService.getAllUsers();
       }
       if(users.isEmpty()) throw new UserNotFoundException("No user found");
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


    @GetMapping(value="/v1/customer",produces = "application/json")
    public ResponseEntity<?> getCustomer(@Param("strategy") String strategy)  throws UserNotFoundException {
        List<String> listA= new ArrayList<>();
        listA.add("A");
        listA.add("B");
        listA.add("C");
        listA.add("D");
        listA.add("E");

        List<String> listB= new ArrayList<>();
        listB.add("D");
        listB.add("E");
        listB.add("F");
        listB.add("G");
        listB.add("H");
        Map<String,List<String>> map = Map.of("A",listA,"B",listB,"BOTH",listA.stream().filter(listB::contains).toList());


        return ResponseEntity.status(HttpStatus.OK).body(map.get(strategy));
    }


}
