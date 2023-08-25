package com.truenorth.calculator.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity(name="users")
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "users")
public class User implements DatabaseEntity {

//    ● User
//        ○ id
//        ○ username (email)
//        ○ password
//        ○ status (active, inactive)


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;


    private Double userBalance;

    @ManyToOne
    private UserStatus status;

}
