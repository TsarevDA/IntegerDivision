package ru.tsar.integerDivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("¬ведите делимое число: ");
			 int number = scanner.nextInt();
			 System.out.println("¬ведите делитель: ");
			 int divisor = scanner.nextInt();
			 Divider.division(number, divisor);
		}
	}

}
