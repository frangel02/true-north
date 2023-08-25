package com.truenorth.calculator.repository;

import com.truenorth.calculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {


    @Query("select u from User u where u.id =: id and u.status =: status")
    Optional<User> finUserByMy(@Param(value = "id")Integer id, @Param(value = "status")Integer status);
}
