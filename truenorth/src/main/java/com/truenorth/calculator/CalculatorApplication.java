package com.truenorth.calculator;

import com.truenorth.calculator.model.OperationType;
import com.truenorth.calculator.model.User;
import com.truenorth.calculator.model.UserStatus;
import com.truenorth.calculator.repository.OperationTypeRepository;
import com.truenorth.calculator.repository.UserRepository;
import com.truenorth.calculator.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;


    @Bean
    CommandLineRunner init() {


        List<OperationType> operationTypeList = new ArrayList<>();


       // operationTypeRepository.saveAll(operationTypeList);


        List<UserStatus> userStatusList = new ArrayList<>();



        return args -> {

            //User status
            userStatusList.add(new UserStatus(1,"ACTIVE"));
            userStatusList.add(new UserStatus(2,"INACTIVE"));


            //operation Types
            //operationTypeList.add(new OperationType(1,"ADDITION",5));
            operationTypeList.add(new OperationType(0,"ADDITION",5));

            operationTypeList.add(new OperationType(0,"SUBSTRACTION",6));

            operationTypeList.add(new OperationType(0,"MULTIPLICATION",18));

            operationTypeList.add(new OperationType(0,"DIVISION",20));
            operationTypeList.add(new OperationType(0,"SQUARE_ROOT",15));
            operationTypeList.add(new OperationType(0,"RANDOM_STRING",10));



            userStatusRepository.saveAll(userStatusList);
            operationTypeRepository.saveAll(operationTypeList);


            Stream.of("truenort", "frangel","trueNorth2").forEach(name -> {
                User user = new User(1 ,name.toLowerCase() + "@domain.com","password123",20.0 ,UserStatus.ACTIVE);
                    userRepository.save(user);
            });



           // userRepository.findAll().forEach(System.out::println);
        };
    }

}
