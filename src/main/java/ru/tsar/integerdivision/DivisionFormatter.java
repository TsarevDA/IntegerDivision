package ru.tsar.integerdivision;

import java.util.List;

public class DivisionFormatter {

	public String format(DivisionResult result) {

		int dividend = result.getDividend();
		int divisor = result.getDivisor();
		String resultString = Integer.toString(result.getResult());
		List<String> minuendNumbers = result.getMinuendNumbers();
		List<String> subtrahendNumbers = result.getSubtrahendNumbers();
		List<Integer> subtractionResults = result.getSubtractionResults();
		StringBuilder outString = new StringBuilder();

		boolean negativeNumber = (dividend < 0) ? true : false;

		int numberLength = Divider.integerLength(dividend);
		outString.append("_" + dividend + "|" + divisor + "\n");
		if (negativeNumber) {
			outString.append(" ");
		}
		outString.append(" " + subtrahendNumbers.get(0));
		for (int i = 0; i < numberLength - subtrahendNumbers.get(0).length(); i++) {
			outString.append(" ");
		}
		outString.append("|");
		for (int i = 0; i < resultString.length(); i++) {
			outString.append("-");
		}
		outString.append("\n ");
		if (negativeNumber) {
			outString.append(" ");
		}
		for (int i = 0; i < subtrahendNumbers.get(0).length(); i++) {
			outString.append("-");
		}
		for (int i = 0; i < numberLength - subtrahendNumbers.get(0).length(); i++) {
			outString.append(" ");
		}
		outString.append("|" + resultString);

	
		StringBuilder shift = new StringBuilder();
		StringBuilder shiftBuffer = new StringBuilder();
		int shiftBufferLength = 0;

		for (int i = 1; i < minuendNumbers.size(); i++) {
			while (subtrahendNumbers.get(i).equals("0")) {
				subtrahendNumbers.remove(i);
			}

			int substractionResultsLength = Divider.integerLength(subtractionResults.get(i - 1));
			while ((minuendNumbers.get(i - 1).length() - substractionResultsLength) > 0) {
				shift.insert(0, " ");
				substractionResultsLength++;
			}

			shiftBuffer.append(shift);
			shiftBuffer.append(minuendNumbers.get(i));
			outString.append("\n" + shiftBuffer);
			
			shiftBufferLength = shiftBuffer.length();
			shiftBuffer.delete(0, shiftBuffer.length());

			for (int j = 0; j < shiftBufferLength - subtrahendNumbers.get(i).length(); j++) {
				shiftBuffer.append(" ");
			}

			shiftBuffer.append(subtrahendNumbers.get(i));
			outString.append("\n" + shiftBuffer);
			shiftBufferLength = shiftBuffer.length();
			shiftBuffer.delete(0, shiftBuffer.length());

			for (int j = 0; j < shiftBufferLength - subtrahendNumbers.get(i).length(); j++) {
				shiftBuffer.append(" ");
			}
			shiftBufferLength = shiftBuffer.length();

			for (int k = 0; k < subtrahendNumbers.get(i).length(); k++) {
				shiftBuffer.append("-");
			}

			outString.append("\n" + shiftBuffer);
			shiftBuffer.delete(0, shiftBuffer.length());
		}

		for (int i = 0; i < shiftBufferLength; i++) {
			shiftBuffer.append(" ");
		}
		int substractionResultsLength = Divider.integerLength(subtractionResults.get(subtractionResults.size() - 1));
		while ((minuendNumbers.get(minuendNumbers.size() - 1).length() - substractionResultsLength) > 0) {
			shiftBuffer.insert(0, " ");
			substractionResultsLength++;
		}
		outString.append("\n"+shiftBuffer);
		outString.append( subtractionResults.get(subtractionResults.size() - 1));
		return outString.toString();
	}

}
