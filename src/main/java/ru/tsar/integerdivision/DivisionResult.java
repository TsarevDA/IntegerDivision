package ru.tsar.integerdivision;

import java.util.List;

public class DivisionResult {
	private int dividend;
	private int divisor;
	private int result;
	private DivisionSteps steps;
	


	public DivisionResult(int dividend, int divisor, int result) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.result = result;
		steps = new DivisionSteps();

	}

	public DivisionResult(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.result = 0;
		steps = new DivisionSteps();

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
	
	public DivisionSteps getSteps() {
		return steps;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
		
	public void setMinuendNumber(int minuendNumber) {
		steps.setMinuendNumber(minuendNumber);
	}

	public void setSubtractionResult (int substractionResult) {
		steps.setSubstractionResult(substractionResult);
	}

	public void setSubtrahendNumber(int subtrahendNumber) {
		steps.setSubtrahendNumber(subtrahendNumber);
	}
	
	public List<Integer> getMinuedNumbers() {
		return steps.getMinuendNumber();
	}
	
	public List<Integer> getSubtractionResults(){
		return steps.getSubstractionResult();
	}
	public List<Integer> getSubtrahendNumber(){
		return steps.getSubtrahendNumber();
	}

}
