package com.truenorth.calculator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class OperationType implements DatabaseEntity {


//    ● Operation
//        ○ id
//        ○ type (addition, subtraction, multiplication, division, square_root, random_string)
//        ○ cost




    public static OperationType ADDITION = new OperationType(1,"ADDITION",5);
    public static OperationType SUBSTRACTION = new OperationType(2,"SUBSTRACTION",6);
    public static OperationType MULTIPLICATION = new OperationType(3,"MULTIPLICATION",18);
    public static OperationType DIVISION = new OperationType(4,"DIVISION",20);
    public static OperationType SQUARE_ROOT = new OperationType(5,"SQUARE_ROOT",15);
    public static OperationType RANDOM_STRING = new OperationType(6,"RANDOM_STRING",10);


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String typeName;
    private Integer cost;


    public OperationType(Integer id, String typeName, Integer cost) {
        this.id = id;
        this.typeName = typeName;
        this.cost = cost;
    }
}
