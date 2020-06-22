package ru.tsar.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {
	
	private int dividend;
	private int divisor;
	private int result;
	private List<DivisionStep> steps ;

	


	public DivisionResult(int dividend, int divisor, int result) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.result = result;
		steps = new ArrayList<>();

	}

	public DivisionResult(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.result = 0;
		steps = new ArrayList<>();

	}
	
	public int getDivisor() {
		return divisor;
	}

	public int getResult() {
		return result;
	}

	public int getDividend() {
		return dividend;
	}
	
	public List<DivisionStep> getSteps() {
		return steps;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
		
	public void setSteps(DivisionStep step) {
		this.steps.add(step);
	}
	public void setSteps(int minuend, int subtrahend, int subtraction) {
		DivisionStep step = new DivisionStep(minuend,subtrahend,subtraction);
		this.steps.add(step);
	}
}
