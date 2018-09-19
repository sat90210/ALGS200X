package com.learningjava;

import java.util.*;

public class FibonacciSumLastDigit {
	private static long getFibonacciSumNaive(long n) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;
		long sum = 1;

		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			sum += current;
		}

		return sum % 10;
	}

	private static int getFibonacciSumFast(long n) {
		if (n <= 1) {
			return (int)n;
		}

		
		//fib[i] % 10 has a pissano period of 10 
	    // i.e fib[i]%10 repeats itself after every 60 times.
		// get index of fib[n+2]%60
		int newNumber = (int) ((n + 2) % 60);

		int[] reminder = new int[newNumber + 1];
		
		reminder[0] = 0;
		reminder[1] = 1;

		// populate all modulo reminders
		for (int i = 2; i < newNumber + 1; i++) {
			reminder[i] = (reminder[i - 2] + reminder[i - 1]) % 10;
		}
		
		//equals to F(n+2)-1
		return (reminder[newNumber]+9)%10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = getFibonacciSumNaive(n);
		int fastS = getFibonacciSumFast(n);
		System.out.println(s);
		System.out.println(fastS);
	}
}