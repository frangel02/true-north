package com.truenorth.calculator.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode.Exclude;



@Data
@NoArgsConstructor
@Entity
public class UserStatus implements DatabaseEntity {


    public static UserStatus ACTIVE = new UserStatus(1,"Active");
    public static UserStatus INACTIVE = new UserStatus(2,"Inactive");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Exclude
    private String status;


    public UserStatus(Integer id,String status) {
        this.id = id;
        this.status = status;
    }

}
