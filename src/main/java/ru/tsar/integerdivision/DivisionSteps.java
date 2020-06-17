package ru.tsar.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionSteps {


private List<Integer> minuendNumbers;
private List<Integer> subtrahendNumbers;
private List<Integer> subtractionResults;

public DivisionSteps() {
	minuendNumbers = new ArrayList<>();
	subtrahendNumbers = new ArrayList<>();
	subtractionResults = new ArrayList<>();
}

public void setMinuendNumber(int minuendNumber) {
	minuendNumbers.add(minuendNumber);
}

public void setSubstractionResult (int substractionResult) {
	subtractionResults.add(substractionResult);
}

public void setSubtrahendNumber(int subtrahendNumber) {
	subtrahendNumbers.add(subtrahendNumber);
}

public List<Integer> getMinuendNumber() {
	return this.minuendNumbers;
}

public List<Integer> getSubtrahendNumber() {
	return this.subtrahendNumbers;
}

public List<Integer> getSubstractionResult() {
	return this.subtractionResults;
}




}
