package ru.tsar.integerdivision;

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
		StringBuilder outString = new StringBuilder();
		outString.append(init(dividend, divisor, steps.get(0).getMinuend(), steps.get(0).getSubtrahend(),
				Integer.toString(divisionResult.getResult())));
		StringBuilder shift = new StringBuilder();
		shift.append(" ");
		for (int i = 1; i < steps.size(); i++) {
			int shiftCount = 0;
			while (steps.get(i).getSubtrahend() == 0) {
				shiftCount++;
				steps.remove(i);

			}
			System.out.println(steps.get(i - 1).getMinuend());
			System.out.println(steps.get(i - 1).getSubtraction());
			shift.append(
					shiftDivisionResults(steps.get(i - 1).getMinuend(), steps.get(i - 1).getSubtraction(), shiftCount));
			outString.append(System.lineSeparator() + shift.substring(1) + "_" + steps.get(i).getMinuend());
			outString.append(System.lineSeparator() + shift + steps.get(i).getSubtrahend());
			StringBuilder streak = new StringBuilder();
			
			for (int k = 0; k < Divider.getIntegerLength(steps.get(i).getSubtrahend()); k++) {
				streak.append("-");
			}
			outString.append(System.lineSeparator() + shift + streak);
		}

		shift.insert(0, insertSpace(Divider.getIntegerLength(steps.get(steps.size() - 1).getMinuend())
				- Divider.getIntegerLength(steps.get(steps.size() - 1).getSubtraction())));

		outString.append(System.lineSeparator() + shift);
		outString.append(steps.get(steps.size() - 1).getSubtraction());

		return outString.toString();
	}

	public StringBuilder init(int dividend, int divisor, int minuend, int subtrahend, String resultString) {
		boolean negativeNumber = (dividend < 0) ? true : false;
		int numberLength = Divider.getIntegerLength(dividend);
		StringBuilder outString = new StringBuilder();

		outString.append("_" + dividend + "|" + divisor + System.lineSeparator());
		if (negativeNumber) {
			outString.append(" ");
		}

		outString.append(insertSpace(Divider.getIntegerLength(minuend) - Divider.getIntegerLength(subtrahend)));
		outString.append(" " + subtrahend);
		outString.append(insertSpace(numberLength - Divider.getIntegerLength(subtrahend)));
		outString.append("|");

		for (int i = 0; i < resultString.length(); i++) {
			outString.append("-");
		}
		outString.append(System.lineSeparator() + " ");
		if (negativeNumber) {
			outString.append(" ");
		}

		for (int i = 0; i < Divider.getIntegerLength(subtrahend); i++) {
			outString.append("-");
		}

		outString.append(insertSpace(numberLength - Divider.getIntegerLength(subtrahend)));
		outString.append("|" + resultString);

		return outString;
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
