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
		List<Integer> dividendDigits = new ArrayList<>();
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if (divisor > dividend) {
			result.setResult(0);
			result.setSteps(0, 0, 0);
			return result;
		}

		dividendDigits = convertNumberToDigists(dividend);
		int minuend = 0;
		int subtractionResult = 0;
		int minuendLengthCounter = 0;
		int subtrahend = 0;

		for (int i = 1; i < dividendDigits.size() + 1; i++) {
			if (minuend == 0) {
				minuend = dividendDigits.get(dividendDigits.size() - i);
				minuendLengthCounter++;
			} else {
				minuend = (int) (minuend
						* Math.pow(10, getIntegerLength(dividendDigits.get((dividendDigits.size() - i)))))
						+ dividendDigits.get(dividendDigits.size() - i);
				minuendLengthCounter++;
			}

			if (divisor <= minuend) {
				subtrahend = (minuend / divisor) * divisor;
				subtractionResult = minuend - subtrahend;
				if (result.getResult() !=0) {
					while (minuendLengthCounter > 1) {
						minuendLengthCounter--;
						result.setResult(result.getResult()*10);
						result.setSteps(0, 0, 0);
					}
				}
				result.setSteps(minuend, subtrahend, subtractionResult);
				result.setResult(result.getResult()*10+minuend / divisor);
				minuendLengthCounter = 0;
				minuend = subtractionResult;
			}
		}

		while (minuendLengthCounter > 0) {
			minuendLengthCounter--;
			result.setResult(result.getResult()*10);
		}

		if ((initialDividend < 0 && initialDivisor > 0) || initialDividend > 0 && initialDivisor < 0) {
			result.setResult(result.getResult()*(-1));
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

	public static List<Integer> convertNumberToDigists(int number) {
		
		List<Integer> digits = new ArrayList<>();
		for (int i = getIntegerLength(number); i > 0; i--) {
			digits.add(number % 10);
			number /= 10;
		}
		return digits;
	}
}
