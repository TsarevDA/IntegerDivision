package ru.tsar.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {
	private int dividend;
	private int divisor;
	private int result;
	private List<String> minuendNumbers;
	private List<String> subtrahendNumbers;
	private List<Integer> subtractionResults;

	public DivisionResult(int dividend, int divisor, int result) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.result = result;
		minuendNumbers = new ArrayList<>();
		subtrahendNumbers = new ArrayList<>();
		subtractionResults = new ArrayList<>();
	}

	public DivisionResult(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		minuendNumbers = new ArrayList<>();
		subtrahendNumbers = new ArrayList<>();
		subtractionResults = new ArrayList<>();
	}

	public int getDivisor() {
		return divisor;
	}

	public int getResult() {
		return result;
	}

	public List<String> getMinuendNumbers() {
		return minuendNumbers;
	}

	public List<String> getSubtrahendNumbers() {
		return subtrahendNumbers;
	}

	public List<Integer> getSubtractionResults() {
		return subtractionResults;
	}

	public int getDividend() {
		return dividend;
	}

	public void setMinuend(String minuend) {
		minuendNumbers.add(minuend);
	}

	public void setMinuend(int minuend) {
		minuendNumbers.add(Integer.toString(minuend));
	}

	public void setSubstrahend(String subtrahend) {
		subtrahendNumbers.add(subtrahend);
	}

	public void setSubstrahend(int subtrahend) {
		subtrahendNumbers.add(Integer.toString(subtrahend));
	}

	public void setSubtractionResults(int substractionResult) {
		subtractionResults.add(substractionResult);
	}

	public void setResult(int result) {
		this.result = result;
	}

}
