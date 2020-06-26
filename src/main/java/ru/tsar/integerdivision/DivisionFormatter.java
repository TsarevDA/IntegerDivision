package ru.tsar.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionFormatter {

	public String format(DivisionResult divisionResult) {
		if (divisionResult == null) {
			throw new IllegalArgumentException("result can't be null");
		}
		if (divisionResult.getSteps().isEmpty()) {
			throw new IllegalArgumentException("division steps can't be empty");
		}
		int dividend = divisionResult.getDividend();
		int divisor = divisionResult.getDivisor();
		List<DivisionStep> steps = divisionResult.getSteps();
		StringBuilder formattedResult = new StringBuilder();
		formattedResult.append(init(dividend, divisor, steps.get(0).getMinuend(), steps.get(0).getSubtrahend(),
				Integer.toString(divisionResult.getResult())));
		StringBuilder shift = new StringBuilder();
		shift.append(" ");
		int shiftCount = 0;
		List<Integer> resultDigits = new ArrayList<>();
		resultDigits = Divider.converNumberToDigists(divisionResult.getResult());

		for (int i = 1; i < Divider.getIntegerLength(divisionResult.getResult()); i++) {
			if (resultDigits.get(i)==0) {
				shiftCount++;
			}  else  {
			shift.append(
					shiftDivisionResults(steps.get(i - 1-shiftCount).getMinuend(), steps.get(i - 1-shiftCount).getSubtraction(), shiftCount));
			formattedResult.append(System.lineSeparator() + shift.substring(1) + "_" + steps.get(i-shiftCount).getMinuend());

			StringBuilder streak = new StringBuilder();
			
			for (int k = 0; k < Divider.getIntegerLength(steps.get(i-shiftCount).getSubtrahend()); k++) {
				streak.append("-");
			}
			if (Divider.getIntegerLength(steps.get(i-shiftCount).getMinuend())>Divider.getIntegerLength(steps.get(i-shiftCount).getSubtrahend())) {
				formattedResult.append(System.lineSeparator() + shift + " "+ steps.get(i-shiftCount).getSubtrahend());
				formattedResult.append(System.lineSeparator() + shift + " "+ streak);
			} else {
			formattedResult.append(System.lineSeparator() + shift + steps.get(i-shiftCount).getSubtrahend());
			formattedResult.append(System.lineSeparator() + shift + streak);
			}
			
			}
	
		}

		shift.insert(0, insertSpace(Divider.getIntegerLength(steps.get(steps.size() - 1).getMinuend())
				- Divider.getIntegerLength(steps.get(steps.size() - 1).getSubtraction())));

		formattedResult.append(System.lineSeparator() + shift);
		formattedResult.append(steps.get(steps.size() - 1).getSubtraction());

		return formattedResult.toString();
	}

	public StringBuilder init(int dividend, int divisor, int minuend, int subtrahend, String resultString) {
		boolean negativeNumber = (dividend < 0) ? true : false;
		int numberLength = Divider.getIntegerLength(dividend);
		StringBuilder formattedResult = new StringBuilder();

		formattedResult.append("_" + dividend + "|" + divisor + System.lineSeparator());
		if (negativeNumber) {
			formattedResult.append(" ");
		}

		formattedResult.append(insertSpace(Divider.getIntegerLength(minuend) - Divider.getIntegerLength(subtrahend)));
		formattedResult.append(" " + subtrahend);
		formattedResult.append(insertSpace(numberLength - Divider.getIntegerLength(subtrahend)));
		formattedResult.append("|");

		for (int i = 0; i < resultString.length(); i++) {
			formattedResult.append("-");
		}
		formattedResult.append(System.lineSeparator() + " ");
		if (negativeNumber) {
			formattedResult.append(" ");
		}

		for (int i = 0; i < Divider.getIntegerLength(subtrahend); i++) {
			formattedResult.append("-");
		}

		formattedResult.append(insertSpace(numberLength - Divider.getIntegerLength(subtrahend)));
		formattedResult.append("|" + resultString);

		return formattedResult;
	}

	public static StringBuilder insertSpace(int spaceAmount) {
		StringBuilder shift = new StringBuilder();
		for (int i = 0; i < spaceAmount; i++) {
			shift.append(" ");
		}
		return shift;
	}

	public StringBuilder shiftDivisionResults(int minuend, int subtraction, int shiftCouner) {
		StringBuilder shift = new StringBuilder();
		shift.append(insertSpace(shiftCouner-1));
		if (subtraction == 0) {
			shift.append(insertSpace(Divider.getIntegerLength(minuend)));
		} else {
			shift.append(insertSpace(Divider.getIntegerLength(minuend) - Divider.getIntegerLength(subtraction)));
		}

		return shift;
	}

}
