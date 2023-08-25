package com.truenorth.calculator.repository;

import com.truenorth.calculator.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType,Integer> {
}
