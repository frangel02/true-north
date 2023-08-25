package com.truenorth.calculator.service;

import com.truenorth.calculator.model.Equation;

public interface IEquation {

	 Equation add(Double left, Double right);


	  Equation subtract(Double left, Double right);

	  Equation multiply(Double left, Double right);

	  Equation divide(Double left, Double right);

	  Equation squareRoot(Double square);

}