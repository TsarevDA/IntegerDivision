package ru.tsar.integerDivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("������� ������� �����: ");
			 int number = scanner.nextInt();
			 System.out.println("������� ��������: ");
			 int divisor = scanner.nextInt();
			 Divider.division(number, divisor);
		}
	}

}
