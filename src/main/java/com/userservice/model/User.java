package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long user_id;
    int mobile_number;
    String first_name;
    String last_name;
    double spending_limit;
    List<Address> customer_address;

}
