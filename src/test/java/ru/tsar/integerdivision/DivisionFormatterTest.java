package ru.tsar.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {

	private DivisionFormatter formatter;
	private DivisionResult result;

	@BeforeEach
	void setUp() {
		formatter = new DivisionFormatter();
	}

	@Test
	void givenNull_whenFormat_thenIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> formatter.format(null));
	}

	@Test
	void givenEmptyDivisionSteps_whenFormat_thenIllegalArgumentException() {
		result = new DivisionResult(1, 1);
		assertThrows(IllegalArgumentException.class, () -> formatter.format(result));
	}

	@Test
	void givenDivision_whenFormat_thenPrintResult() {
		Divider divider = new Divider();
		DivisionResult result = divider.division(123, 5);
		String actual = formatter.format(result);
		String expected = 
				("_123|5" + System.lineSeparator() +
				 " 10 |--" + System.lineSeparator() +
				 " -- |24"	+ System.lineSeparator() + 
				 " _23" + System.lineSeparator() +
				 "  20" + System.lineSeparator() + 
				 "  --"+ System.lineSeparator() +
				 "   3");
		assertEquals(expected, actual);
	}

	@Test
	void givenDivisionWithoutMod_whenFormat_thenPrintResult() {
		Divider divider = new Divider();
		DivisionResult result = divider.division(120015, 15);
		String actual = formatter.format(result);
		String expected = 
				("_120015|15" + System.lineSeparator() +
				 " 120   |----" + System.lineSeparator() +
				 " ---   |8001"	+ System.lineSeparator() + 
				 "    _15" + System.lineSeparator() +
				 "     15" + System.lineSeparator() + 
				 "     --"+ System.lineSeparator() +
				 "      0");
		assertEquals(expected, actual);
	}

	
	@Test
	void givenZeroDividend_whenFormat_thenPrintZeroResult() {
		Divider divider = new Divider();
		DivisionResult result = divider.division(0, 128);
		String actual = formatter.format(result);
		String expected = ("_0|128" + System.lineSeparator() + " 0|-" + System.lineSeparator() + " -|0"
				+ System.lineSeparator() + " 0");
		assertEquals(expected, actual);
	}

	@Test
	void givenDividendMoreThanDivisor_whenFormat_thenPrintZeroResult() {
		Divider divider = new Divider();
		DivisionResult result = divider.division(1, 2);
		String actual = formatter.format(result);
		String expected = ("_1|2" + System.lineSeparator() + " 0|-" + System.lineSeparator() + " -|0"
				+ System.lineSeparator() + " 0");
		assertEquals(expected, actual);
	}

}
