package com.java.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "calculator")
@RequestScoped
public class CalculatorBean {

	private Double firstNumber;
	private Double secondNumber;
	private String result;

	public CalculatorBean() {
	}

	public Double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public String getResult() {
		return result;
	}

	public void add() {
		this.result = "Result " + (firstNumber + secondNumber);
	}

	public void subtract() {
		this.result = "Result " + (firstNumber - secondNumber);
	}

	public void multiply() {
		this.result = "Result " + (firstNumber * secondNumber);
	}

	public void divide() {
		this.result = "Result " + (firstNumber / secondNumber);
	}
}
