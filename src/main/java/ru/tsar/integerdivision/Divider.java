package ru.tsar.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class Divider {

	public DivisionResult division(int dividend, int divisor) {
		int numberLength = integerLength(dividend);
		boolean isNegative = false;
		int initialDividend = dividend;
		int initialDivisor = divisor;
		DivisionResult result = new DivisionResult(dividend, divisor);
		List<Integer> answer = new ArrayList<>();
		List<Integer> dividendDigits = new ArrayList<>();

		
		if (divisor == 0) {
			throw new IllegalArgumentException("Can't divide by zero");
		}
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		
		if (divisor > dividend) {
			result.setSubtractionResults(0);
			result.setMinuend(0);
			result.setSubstrahend(0);
			result.setResult(0);
			return result;
		}

		for (int i = numberLength; i > 0; i--) {
			dividendDigits.add(dividend % 10);
			dividend /= 10;
		}

		int minuend = 0;
		int substractionResult = 0;
		int minuendLengthCounter = 0;
		int subtrahend = 0;
		
		for (int i = 1; i < dividendDigits.size() + 1; i++) {
			if (minuend == 0) {
				minuend = dividendDigits.get(dividendDigits.size() - i);
				minuendLengthCounter++;
			} else {
				minuend = Integer.parseInt(
						Integer.toString(minuend) + Integer.toString((dividendDigits.get(dividendDigits.size() - i))));
				minuendLengthCounter++;
			}

			if (divisor <= minuend) {
				result.setMinuend(minuend);
				subtrahend = (minuend / divisor) * divisor;
				substractionResult = minuend - subtrahend;
				if (answer.size() != 0) {
					while (minuendLengthCounter > 1) {
						minuendLengthCounter--;
						answer.add(0);
						result.setSubstrahend(0);
					}
				}
				answer.add(minuend / divisor);
				minuendLengthCounter = 0;
				minuend = substractionResult;

				result.setSubstrahend(subtrahend);
				result.setSubtractionResults(substractionResult);

			}
		}

		while (minuendLengthCounter > 0) {
			minuendLengthCounter--;
			answer.add(0);
		}

		

		if ((initialDividend < 0 && initialDivisor > 0) || initialDividend > 0 && initialDivisor < 0) {
			isNegative = true;
		}

		
		result.setResult(resultCreate(answer, isNegative));
		return result;
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