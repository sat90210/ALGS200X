package com.learningjava;

import java.util.*;

public class FibonacciPartialSum {

	private static final int[] PISANO_PERIOD_MOD10 = { 0, 1, 1, 2, 3, 5, 8, 3, 1, 4, 5, 9, 4, 3, 7, 0, 7, 7, 4, 1, 5, 6,
			1, 7, 8, 5, 3, 8, 1, 9, 0, 9, 9, 8, 7, 5, 2, 7, 9, 6, 5, 1, 6, 7, 3, 0, 3, 3, 6, 9, 5, 4, 9, 3, 2, 5, 7, 2,
			9, 1 };

	private static long getFibonacciPartialSumNaive(long from, long to) {
		long sum = 0;

		long current = 0;
		long next = 1;

		for (long i = 0; i <= to; ++i) {
			if (i >= from) {
				sum += current;
			}

			long new_current = next;
			next = next + current;
			current = new_current;
		}

		return sum % 10;
	}

	private static int getFibonacciPartialSumFast(long from, long to) {

		int[] reminder = new int[60];

		reminder[0] = 0;
		reminder[1] = 1;

		// first populate all the modulo remaininder up to pisano number 60
		for (int i = 2; i < reminder.length; i++) {
			reminder[i] = (reminder[i - 2] + reminder[i - 1]) % 10;
		}

		int left = (int) from % 60;
		int right = (int) to % 60;
		if (right < left) {
			right += 60;
		}

		int result = 0;
		for (int i = left; i < right + 1; i++) {
			result += reminder[i % 60];
		}

		return result % 10;
	}
	
	static long getFibonacciPartialSumLastDigit(final long from, final long to) {
		final int fromVal = getLastDigitForFib(from + 1);
		int toVal = getLastDigitForFib(to + 2);
		if (toVal < fromVal) {
			toVal += 10;
		}
		return toVal - fromVal;
	}

	private static int getLastDigitForFib(final long l) {
		final long offset = l % PISANO_PERIOD_MOD10.length;
		return PISANO_PERIOD_MOD10[(int) offset];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long from = scanner.nextLong();
		long to = scanner.nextLong();
		System.out.println(getFibonacciPartialSumNaive(from, to));
		System.out.println(getFibonacciPartialSumFast(from, to));
		System.out.println(getFibonacciPartialSumLastDigit(from, to));
	}
}