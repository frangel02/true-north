package com.truenorth.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class OperationType implements DatabaseEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String typeName;
    private Integer cost;


    public OperationType(Integer id) {
        this.id = id;
    }
}
