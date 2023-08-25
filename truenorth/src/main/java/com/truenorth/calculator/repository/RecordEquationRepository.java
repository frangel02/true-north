package com.truenorth.calculator.repository;


import com.truenorth.calculator.model.RecordEquation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordEquationRepository extends JpaRepository<RecordEquation,Long> {
}
