package ru.tsar.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class Divider {

	public DivisionResult division(int dividend, int divisor) {

		if (divisor == 0) {
			throw new IllegalArgumentException("Can't divide by zero");
		}

		int initialDividend = dividend;
		int initialDivisor = divisor;
		DivisionResult result = new DivisionResult(dividend, divisor);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if (divisor > dividend) {
			result.setResult(0);
			result.setSteps(0, 0, 0);
			return result;
		}

		List<Integer> dividendDigits = new ArrayList<>(converNumberToDigists(dividend));
		int minuend = 0;
		int subtractionResult = 0;
		boolean setZeroToResult = false;
		int subtrahend = 0;
		for (int i = 0; i < dividendDigits.size(); i++) {
			if (minuend == 0) {
				minuend = dividendDigits.get(i);
				if (result.getResult() != 0) {
					result.setResult(result.getResult() * 10);
				}
			} else {
				minuend = (int) (minuend * Math.pow(10, getIntegerLength(dividendDigits.get(i))))
						+ dividendDigits.get(i);
				if (result.getResult() != 0) {
					if (setZeroToResult) {
						result.setResult(result.getResult() * 10);
					}
				}
				setZeroToResult = true;
			}

			if (divisor <= minuend) {
				subtrahend = (minuend / divisor) * divisor;
				subtractionResult = minuend - subtrahend;
				result.setSteps(minuend, subtrahend, subtractionResult);
				result.setResult(result.getResult() * 10 + minuend / divisor);
				setZeroToResult = false;
				minuend = subtractionResult;
			}
		}
		result.setRemainder(subtractionResult);

		if ((initialDividend < 0 && initialDivisor > 0) || initialDividend > 0 && initialDivisor < 0) {
			result.setResult(result.getResult() * (-1));
		}
		return result;
	}

	public static int getIntegerLength(int number) {

		number = Math.abs(number);
		int numberLength = 0;
		if (number == 0) {
			return 1;
		}
		while (number > 0) {
			numberLength++;
			number /= 10;
		}
		return numberLength;
	}

	public static List<Integer> converNumberToDigists(int number) {

		List<Integer> digits = new ArrayList<>();
		for (int i = getIntegerLength(number); i > 0; i--) {
			digits.add(0, number % 10);
			number /= 10;
		}
		return digits;
	}
}
