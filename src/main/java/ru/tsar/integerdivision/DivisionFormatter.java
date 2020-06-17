package ru.tsar.integerdivision;

import java.util.List;

public class DivisionFormatter {

	public String format(DivisionResult result) {
		if (result == null) {
			throw new IllegalArgumentException("result can't be null");
		}
		if (result.getMinuedNumbers().isEmpty() || result.getSubtractionResults().isEmpty()
				|| result.getSubtrahendNumber().isEmpty()) {
			throw new IllegalArgumentException("division steps can't be empty");
		}
		int dividend = result.getDividend();
		int divisor = result.getDivisor();
		String resultString = Integer.toString(result.getResult());

		List<Integer> minuendNumbers = result.getMinuedNumbers();
		List<Integer> subtrahendNumbers = result.getSubtrahendNumber();
		List<Integer> subtractionResults = result.getSubtractionResults();
		StringBuilder outString = new StringBuilder();

		boolean negativeNumber = (dividend < 0) ? true : false;

		int numberLength = Divider.integerLength(dividend);
		outString.append("_" + dividend + "|" + divisor + System.lineSeparator());
		if (negativeNumber) {
			outString.append(" ");
		}
		int secondLineShift = 0;

		while ((Divider.integerLength(minuendNumbers.get(0))
				- Divider.integerLength(subtrahendNumbers.get(0))) > secondLineShift) {
			outString.append(" ");
			secondLineShift++;

		}
		outString.append(" " + subtrahendNumbers.get(0));

		for (int i = 0; i < numberLength - Divider.integerLength(subtrahendNumbers.get(0)) - secondLineShift; i++) {
			outString.append(" ");
		}
		outString.append("|");
		for (int i = 0; i < resultString.length(); i++) {
			outString.append("-");
		}
		outString.append(System.lineSeparator() + " ");
		if (negativeNumber) {
			outString.append(" ");
		}

		for (int i = 0; i < Divider.integerLength(subtrahendNumbers.get(0)) + secondLineShift; i++) {
			outString.append("-");
		}

		for (int i = 0; i < numberLength - Divider.integerLength(subtrahendNumbers.get(0)) - secondLineShift; i++) {
			outString.append(" ");
		}

		outString.append("|" + resultString);
		StringBuilder shift = new StringBuilder();
		StringBuilder shiftBuffer = new StringBuilder();
		int shiftBufferLength = 0;
		shift.insert(0, "_");

		for (int i = 1; i < minuendNumbers.size(); i++) {
			while (subtrahendNumbers.get(i).equals(0)) {
				shift.insert(0, " ");
				subtrahendNumbers.remove(i);
			}

			int substractionResultsLength = Divider.integerLength(subtractionResults.get(i - 1));

			while ((Divider.integerLength(minuendNumbers.get(i - 1)) - substractionResultsLength) > 0) {
				shift.insert(0, " ");
				substractionResultsLength++;
			}

			shiftBuffer.append(shift);
			shiftBuffer.append(minuendNumbers.get(i));
			outString.append(System.lineSeparator() + shiftBuffer);
			shiftBufferLength = shiftBuffer.length();
			shiftBuffer.delete(0, shiftBuffer.length());

			for (int j = 0; j < shiftBufferLength - Divider.integerLength(subtrahendNumbers.get(i)); j++) {
				shiftBuffer.append(" ");
			}

			shiftBuffer.append(subtrahendNumbers.get(i));
			outString.append(System.lineSeparator() + shiftBuffer);
			shiftBufferLength = shiftBuffer.length();
			shiftBuffer.delete(0, shiftBuffer.length());

			for (int j = 0; j < shiftBufferLength - Divider.integerLength(subtrahendNumbers.get(i)); j++) {
				shiftBuffer.append(" ");
			}
			shiftBufferLength = shiftBuffer.length();

			for (int k = 0; k < Divider.integerLength(subtrahendNumbers.get(i)); k++) {
				shiftBuffer.append("-");
			}

			outString.append(System.lineSeparator() + shiftBuffer);
			shiftBuffer.delete(0, shiftBuffer.length());
		}

		for (int i = 0; i < shiftBufferLength; i++) {
			shiftBuffer.append(" ");
		}
		int substractionResultsLength = Divider.integerLength(subtractionResults.get(subtractionResults.size() - 1));

		while ((Divider.integerLength(minuendNumbers.get(minuendNumbers.size() - 1)) - substractionResultsLength) > 0) {
			shiftBuffer.insert(0, " ");
			substractionResultsLength++;
		}
		outString.append(System.lineSeparator() + shiftBuffer);
		outString.append(subtractionResults.get(subtractionResults.size() - 1));
		return outString.toString();
	}

}
