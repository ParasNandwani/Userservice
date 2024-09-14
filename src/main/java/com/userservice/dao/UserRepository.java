package com.userservice.dao;

import com.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN u.address a WHERE u.first_name LIKE %:firstName% OR u.last_name LIKE %:lastName% OR a.city LIKE %:city%")
    List<User> findByFirstNameOrLastNameOrCity(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("city") String city);}
