package com.truenorth.calculator.service;


import com.truenorth.calculator.Util.Values;
import com.truenorth.calculator.model.*;
import com.truenorth.calculator.repository.OperationTypeRepository;
import com.truenorth.calculator.repository.RecordEquationRepository;
import com.truenorth.calculator.repository.UserRepository;
import com.truenorth.calculator.service.IEquation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class EquationImpl implements IEquation {


    @Autowired
    //@Resource(name = "EntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Autowired
    private RecordEquationRepository recordEquationRepository;



    @Override
    public Equation add(Double left, Double right) {



//        Optional<User> user = userRepository.finUserByMy(9,Values.ACTIVE.value);
        Optional<User> user = userRepository.findById(9);


        if(user.isPresent() && user.get().getUserBalance()> 0) {

            OperationType operationType = operationTypeRepository.findById(Values.ADDITION.value).get();


            user.get().setUserBalance(user.get().getUserBalance() - operationType.getCost());


            userRepository.save(user.get());

            RecordEquation recordEquation = new RecordEquation();

            recordEquation.setDate(new Date());
            recordEquation.setUser(user.get());
            recordEquation.setOperation(operationType);
            recordEquation.setAmount(new BigDecimal(operationType.getCost()));
            recordEquation.setUserBalance(new BigDecimal(user.get().getUserBalance()));

            Double result = (left + right);
            recordEquation.setOperationResponse(result.toString());
            recordEquationRepository.saveAndFlush(recordEquation);
        }


       // EntityManager entityManager = entityManagerFactory.createEntityManager();
       // EntityTransaction entityTransaction = entityManager.getTransaction();

        //entityTransaction.begin();
//
//        result = q.executeUpdate();
//        et.commit();




        return new Equation(left, right, left + right, "+");

    }

    @Override
    public Equation subtract(Double left, Double right) {


        Optional<User> user = userRepository.findById(9);


        if(user.isPresent() && user.get().getUserBalance()> 0) {

            OperationType operationType = operationTypeRepository.findById(Values.SUBSTRACTION.value).get();


            user.get().setUserBalance(user.get().getUserBalance() - operationType.getCost());

            userRepository.save(user.get());

            RecordEquation recordEquation = new RecordEquation();

            recordEquation.setDate(new Date());
            recordEquation.setUser(user.get());
            recordEquation.setOperation(operationType);
            recordEquation.setAmount(new BigDecimal(operationType.getCost()));
            recordEquation.setUserBalance(new BigDecimal(user.get().getUserBalance()));

            Double result = (left - right);
            recordEquation.setOperationResponse(result.toString());
            recordEquationRepository.saveAndFlush(recordEquation);
        }





        return new Equation(left, right, left - right, "-");
    }

    @Override
    public Equation multiply(Double left, Double right) {


        Optional<User> user = userRepository.findById(9);


        if(user.isPresent() && user.get().getUserBalance()> 0) {

            OperationType operationType = operationTypeRepository.findById(Values.MULTIPLICATION.value).get();


            user.get().setUserBalance(user.get().getUserBalance() - operationType.getCost());


            userRepository.save(user.get());

            RecordEquation recordEquation = new RecordEquation();

            recordEquation.setDate(new Date());
            recordEquation.setUser(user.get());
            recordEquation.setOperation(operationType);
            recordEquation.setAmount(new BigDecimal(operationType.getCost()));
            recordEquation.setUserBalance(new BigDecimal(user.get().getUserBalance()));

            Double result = (left * right);
            recordEquation.setOperationResponse(result.toString());
            recordEquationRepository.saveAndFlush(recordEquation);
        }



        return new Equation(left, right, left * right, "*");
    }

    @Override
    public Equation divide(Double left, Double right) {



        Optional<User> user = userRepository.findById(9);


        if(user.isPresent() && user.get().getUserBalance()> 0) {

            OperationType operationType = operationTypeRepository.findById(Values.DIVISION.value).get();


            user.get().setUserBalance(user.get().getUserBalance() - operationType.getCost());


            userRepository.save(user.get());

            RecordEquation recordEquation = new RecordEquation();

            recordEquation.setDate(new Date());
            recordEquation.setUser(user.get());
            recordEquation.setOperation(operationType);
            recordEquation.setAmount(new BigDecimal(operationType.getCost()));
            recordEquation.setUserBalance(new BigDecimal(user.get().getUserBalance()));

            Double result = (left / right);
            recordEquation.setOperationResponse(result.toString());
            recordEquationRepository.saveAndFlush(recordEquation);
        }

        return new Equation(left, right, left / right, "/");
    }

    @Override
    public Equation squareRoot(Double square){


        Optional<User> user = userRepository.findById(9);


        if(user.isPresent() && user.get().getUserBalance()> 0) {

            OperationType operationType = operationTypeRepository.findById(Values.SQUARE_ROOT.value).get();


            user.get().setUserBalance(user.get().getUserBalance() - operationType.getCost());


            userRepository.save(user.get());

            RecordEquation recordEquation = new RecordEquation();

            recordEquation.setDate(new Date());
            recordEquation.setUser(user.get());
            recordEquation.setOperation(operationType);
            recordEquation.setAmount(new BigDecimal(operationType.getCost()));
            recordEquation.setUserBalance(new BigDecimal(user.get().getUserBalance()));

            Double result =  Math.sqrt(square) ;
            recordEquation.setOperationResponse(result.toString());
            recordEquationRepository.saveAndFlush(recordEquation);
        }



        return new Equation(null, null , Math.sqrt(square) ,".sqrt()")  ;
    }


}
