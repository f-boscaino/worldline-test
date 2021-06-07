package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MultiplesSumTest {

	@Test
	public void sumTest() {
		MultiplesSum multiplesSum = new MultiplesSum();
		assertEquals(18, multiplesSum.getSumOfMultiples(3, 11));
		assertEquals(15, multiplesSum.getSumOfMultiples(5, 11));
		assertEquals(7, multiplesSum.getSumOfMultiples(7, 11));
		assertEquals(40, multiplesSum.computeMultiplesSum(11));
	}
}
