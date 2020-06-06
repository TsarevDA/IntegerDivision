package ru.tsar.integerDivision;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DividerTest {

	@Test
	void givenZeroDivisior_whenDivide_thenIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> Divider.division(5, 0));
	}

	@Test
	void givenZero_whenDivide_thenZero() {
		double expected = 0;
		double actual = Divider.division(0, 5);
		assertEquals(expected, actual);
	}

	@Test
	void givenNumberDividedWithoutMod_whenDivide_thenInteger() {
		double expected = 20;
		double actual = Divider.division(100, 5);
		assertEquals(expected, actual);
	}

	@Test
	void givenNumberDividedWithtMod_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 1;
		double actual = Divider.division(7, 4);
		assertEquals(expected, actual);
	}

	@Test
	void givenBigLengthNumber_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 1504;
		double actual = Divider.division(7524, 5);
		assertEquals(expected, actual);
	}

	@Test
	void givenDivisorMoreThanNumber_whenDivide_thenZero() {
		int expected = 0;
		int actual = Divider.division(1, 128);
		assertEquals(expected, actual);
	}

	@Test
	void givenNumberWithZeroesIntheMiddle_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 80001;
		double actual = Divider.division(1200015, 15);
		assertEquals(expected, actual);
	}

	@Test
	void givenNumberWithZeroesInTheEnd_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 300;
		double actual = Divider.division(1500, 5);
		assertEquals(expected, actual);
	}

	@Test
	void givenOneNegative_whenDivide_thenNegative() {
		int expected = -2;
		int actual = Divider.division(-10, 5);
		assertEquals(expected, actual);
	}

	@Test
	void givenTwoNegative_whenDivide_thenPositive() {
		int expected = 1;
		int actual = Divider.division(-5, -5);
		assertEquals(expected, actual);
	}

}
