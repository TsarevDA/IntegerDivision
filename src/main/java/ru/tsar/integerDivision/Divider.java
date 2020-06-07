package ru.tsar.integerDivision;

import java.util.ArrayList;
import java.util.List;

public class Divider {

	public static int division(int number, int divisor) {
		int numberLength = integerLength(number);
		int result = 0;
		boolean isNegative = false;
		int firstNumber = number;
		int firstDivisor = divisor;

		List<Integer> answer = new ArrayList<>();
		List<String> subtrahends = new ArrayList<>();
		List<Integer> subtractionResults = new ArrayList<>();
		List<String> minuedNumbers = new ArrayList<>();

		if ((number < 0 && divisor > 0) || number > 0 && divisor < 0) {
			isNegative = true;
		}
		number = Math.abs(number);
		divisor = Math.abs(divisor);
		if (divisor == 0) {
			throw new IllegalArgumentException("Can't divide by zero");
		} else if (divisor > number) {
			Printing.init(number, divisor, "0", false, "0");
			return 0;

		} else {

			while (number >= divisor) {
				int minuedNumberLength = 0;
				double requiredNumberLength = 1.0;
				int numberBuffer = 0;

				while (divisor > numberBuffer) {
					requiredNumberLength = Math.pow(10, (numberLength - minuedNumberLength - 1));
					numberBuffer = (int) (number / requiredNumberLength);
					minuedNumberLength++;
				}
				int previousMinuedNumberLength = minuedNumberLength;

				if (!answer.isEmpty()) {
					while (minuedNumberLength
							- integerLength(subtractionResults.get(subtractionResults.size() - 1)) > 1) {

						answer.add(0);
						minuedNumberLength--;
					}
				}
				minuedNumbers.add(Integer.toString(numberBuffer));
				subtrahends.add(Integer.toString((numberBuffer / divisor) * divisor));
				subtractionResults.add(numberBuffer - ((numberBuffer / divisor) * divisor));
				answer.add( numberBuffer / divisor);

				number = (int) (number - (numberBuffer / divisor) * divisor * requiredNumberLength);
				int previousNumberLength = numberLength;
				numberLength = integerLength(number);

				if (subtractionResults.get(subtractionResults.size() - 1) == 0) {
					while (previousNumberLength - previousMinuedNumberLength > numberLength) {
						answer.add(0);
						subtrahends.add("0");
						previousNumberLength--;
					}
				}
			}
			result = resultCreate(answer, isNegative);

			Printing.printDivider(firstNumber, firstDivisor, Integer.toString(result), minuedNumbers, subtrahends,
					subtractionResults);
			return result;
		}
	}

	public static int integerLength(int number) {
		number = Math.abs(number);
		int numberLength = 0;
		if (number == 0) {
			return 0;
		}
		while (number > 0) {
			numberLength++;
			number /= 10;
		}
		return numberLength;
	}

	public static int resultCreate(List<Integer> answer, boolean isNegative) {
		int result = 0;
		for (int i = 0; i < answer.size(); i++) {
			result += answer.get(i) * (Math.pow(10, answer.size() - 1 - i));
		}
		if (isNegative) {
			result = -result;
		}
		return result;
	}

}
