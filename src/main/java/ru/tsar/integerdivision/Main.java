package ru.tsar.integerdivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("������� ������� �����: ");
			int dividend = scanner.nextInt();
			System.out.println("������� ��������: ");
			int divisor = scanner.nextInt();
			Divider divider = new Divider();
			DivisionResult  result = divider.division(dividend, divisor);
			DivisionFormatter formatter = new DivisionFormatter();
			System.out.println(formatter.format(result));
		}
	}
}
