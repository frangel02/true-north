package com.truenorth.calculator.controller;

import com.truenorth.calculator.model.Equation;
import com.truenorth.calculator.service.EquationImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Log4j2
@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController  {


	private EquationImpl equation;


	public CalculatorController(EquationImpl equation) {
		this.equation = equation;
	}

	@GetMapping("/addition")
	public ResponseEntity<Equation> add(@RequestParam(value = "param1", required = true) String param1,
										@RequestParam(value = "param2", required = true) String param2) {
		try {
			return ResponseEntity.ok(this.equation.add(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<>(new Equation("+"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/subtraction")
	public ResponseEntity<Equation> subtract(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			return ResponseEntity.ok(this.equation.subtract(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<>(new Equation("-"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/multiplication")
	public ResponseEntity<Equation> multiply(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			return ResponseEntity.ok(this.equation.multiply(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<Equation>(new Equation("*"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/division")
	public ResponseEntity<Equation> division(@RequestParam(value = "param1", required = true) String param1,
			@RequestParam(value = "param2", required = true) String param2) {
		try {
			Double denominator = Double.parseDouble(param2);
			if (denominator == 0.0) {
				throw new ArithmeticException();
			}
			return ResponseEntity.ok(this.equation.divide(Double.parseDouble(param1), Double.parseDouble(param2)));
		} catch (Exception e) {
			return new ResponseEntity<>(new Equation("/"), HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/squareRoot")
	public ResponseEntity<Equation> squareRoot(@RequestParam(value = "param1", required = true) String param) {
		try {
			Double denominator = Double.parseDouble(param);
			if (denominator == 0.0) {
				throw new ArithmeticException();
			}
			return ResponseEntity.ok(this.equation.squareRoot(Double.parseDouble(param)));
		} catch (Exception e) {
			return new ResponseEntity<>(new Equation("/"), HttpStatus.BAD_REQUEST);
		}
	}
}
