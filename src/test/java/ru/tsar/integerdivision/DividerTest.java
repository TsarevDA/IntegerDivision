package ru.tsar.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.tsar.integerdivision.Divider;

class DividerTest {
	private Divider divider;

	@BeforeEach
	void setUp() {
		divider = new Divider();
	}

	@Test
	void givenZeroDivisior_whenDivide_thenIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> divider.division(5, 0));
	}

	@Test
	void givenZero_whenDivide_thenZero() {
		double expected = 0;
		DivisionResult actual = divider.division(0, 5);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenNumberDividedWithoutMod_whenDivide_thenInteger() {
		double expected = 20;
		DivisionResult actual = divider.division(100, 5);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenNumberDividedWithtMod_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 1;
		DivisionResult actual = divider.division(7, 4);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenBigLengthNumber_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 1504;
		DivisionResult actual = divider.division(7524, 5);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenDivisorMoreThanNumber_whenDivide_thenZero() {
		int expected = 0;
		DivisionResult actual = divider.division(1, 128);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenNumberWithZeroesIntheMiddle_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 80001;
		DivisionResult actual = divider.division(1200015, 15);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenNumberWithZeroesInTheEnd_whenDivide_thenIntegerWithoutRemainder() {
		double expected = 300;
		DivisionResult actual = divider.division(1500, 5);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenOneNegative_whenDivide_thenNegative() {
		int expected = -2;
		DivisionResult actual = divider.division(-10, 5);
		assertEquals(expected, actual.getResult());
	}

	@Test
	void givenTwoNegative_whenDivide_thenPositive() {
		int expected = 1;
		DivisionResult actual = divider.division(-5, -5);
		assertEquals(expected, actual.getResult());
	}

}
