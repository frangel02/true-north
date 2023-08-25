package com.truenorth.calculator.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@Entity
public class RecordEquation implements DatabaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private OperationType operation;

    @ManyToOne
    private User user;

    private BigDecimal amount;


    private BigDecimal userBalance;

    private String operationResponse;

    private Date date;
}
