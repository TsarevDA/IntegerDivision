package ru.tsar.integerDivision;


import java.util.List;

public class Printing {

	public static void printDivider(int number, int divisor, String result, List<String> minuedNumbers,
			List<String> subtrahend, List<Integer> subtractionResults) {
		StringBuilder shift = new StringBuilder();
		StringBuilder shiftBuffer = new StringBuilder();
		int shiftBufferLength = 0;
		boolean negativeNumber = (number < 0) ? true : false;

		init(number, divisor, result, negativeNumber, subtrahend.get(0));

		if (negativeNumber) {
			shift.append(" ");
			shift.append("_");
		} else {
			shift.append("_");
		}

		for (int i = 1; i < minuedNumbers.size(); i++) {

			while (subtrahend.get(i).equals("0")) {
				shift.insert(0, " ");
				subtrahend.remove(i);
			}

			int substractionResultsLength = Divider.integerLength(subtractionResults.get(i - 1));
			while ((minuedNumbers.get(i - 1).length() - substractionResultsLength) > 0) {
				shift.insert(0, " ");
				substractionResultsLength++;
			}

			shiftBuffer.append(shift);
			shiftBuffer.append(minuedNumbers.get(i));
			System.out.println(shiftBuffer);
			shiftBufferLength = shiftBuffer.length();
			shiftBuffer.delete(0, shiftBuffer.length());

			for (int j = 0; j < shiftBufferLength - subtrahend.get(i).length(); j++) {
				shiftBuffer.append(" ");
			}

			shiftBuffer.append(subtrahend.get(i));
			System.out.println(shiftBuffer);
			shiftBufferLength = shiftBuffer.length();
			shiftBuffer.delete(0, shiftBuffer.length());

			for (int j = 0; j < shiftBufferLength - subtrahend.get(i).length(); j++) {
				shiftBuffer.append(" ");
			}

			shiftBufferLength = shiftBuffer.length();

			for (int k = 0; k < subtrahend.get(i).length(); k++) {
				shiftBuffer.append("-");
			}

			System.out.println(shiftBuffer);
			shiftBuffer.delete(0, shiftBuffer.length());
		}

		for (int i = 0; i < shiftBufferLength; i++) {
			shiftBuffer.append(" ");
		}
		int substractionResultsLength = Divider.integerLength(subtractionResults.get(subtractionResults.size() - 1));
		while ((minuedNumbers.get(minuedNumbers.size() - 1).length() - substractionResultsLength) > 0) {
			shiftBuffer.insert(0, " ");
			substractionResultsLength++;
		}

		System.out.print(shiftBuffer);
		System.out.println(subtractionResults.get(subtractionResults.size() - 1));

	}

	public static void init(int number, int divisor, String result, boolean negativeNumber, String subtrahend) {
		int numberLength = Divider.integerLength(number);
		System.out.println("_" + number + "|" + divisor);
		if (negativeNumber) {
			System.out.print(" ");
		}
		System.out.print(" " + subtrahend);
		for (int i = 0; i < numberLength - subtrahend.length(); i++) {
			System.out.print(" ");
		}
		System.out.print("|");
		for (int i = 0; i < result.length(); i++) {
			System.out.print("-");
		}
		System.out.println("");
		System.out.print(" ");
		if (negativeNumber) {
			System.out.print(" ");
		}
		for (int i = 0; i < subtrahend.length(); i++) {
			System.out.print("-");
		}
		for (int i = 0; i < numberLength - subtrahend.length(); i++) {
			System.out.print(" ");
		}
		System.out.print("|");
		System.out.println(result);

	}

}
