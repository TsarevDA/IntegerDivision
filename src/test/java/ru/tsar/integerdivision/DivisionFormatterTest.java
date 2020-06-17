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
		result = new DivisionResult(1,1);
		assertThrows(IllegalArgumentException.class, () -> formatter.format(result));
	}
}
