package com.example.demo;

public class MultiplesSum {

	public long computeMultiplesSum(int n) {
		return getSumOfMultiples(3, n) + getSumOfMultiples(5, n) + getSumOfMultiples(7, n);
	}

	public long getSumOfMultiples(int base, int limit) {
		long sumOfMultiples = 0;
		for(int i = 1; base * i < limit; sumOfMultiples += base * i++);
		return sumOfMultiples;
	}
}
