package ru.tsar.integerdivision;



public class DivisionStep {

private int minuend;
private int subtrahend;
private int subtraction;


public DivisionStep(int minuendNumber, int subtrahendNumber, int subtractionResult) {
	this.minuend = minuendNumber;
	this.subtrahend = subtrahendNumber;
	this.subtraction = subtractionResult;
}

public void setMinuendNumber(int minuend) {
	this.minuend = minuend;
}

public void setSubtractionResult (int subtraction) {
	this.subtraction = subtraction;
}

public void setSubtrahendNumber(int subtrahend) {
	this.subtrahend = subtrahend;
}

public int getMinuend() {
	return this.minuend;
}

public int getSubtrahend() {
	return this.subtrahend;
}

public int getSubtraction() {
	return this.subtraction;
}

public void setStep(int minuend, int subtrahend, int subtraction) {
	this.minuend = minuend;
	this.subtrahend = subtrahend;
	this.subtraction = subtraction;
}




}
