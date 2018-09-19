package com.learningjava;

import java.util.Scanner;

public class Fibonacci {

	private static long calcFibRecursive(int n) {
		if (n <= 1) {
			return n;
		}
		return calcFibRecursive(n - 1) + calcFibRecursive(n - 2);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		/*System.out.println(calcFibRecursive(n));
		System.out.println(calcFibLoop(n));*/
		System.out.println(lastDigitOfNthFibonacciNumber(n));
	}

	private static long calcFibLoop(int n) {
		if (n <= 1) {
			return n;
		}
		int[] fibonacciNumberArray = new int[n + 1];
		if (n > 1) {

			fibonacciNumberArray[0] = 0;
			fibonacciNumberArray[1] = 1;
			for (int i = 2; i <= n; i++) {
				fibonacciNumberArray[i] = fibonacciNumberArray[i - 1] + fibonacciNumberArray[i - 2];
				// System.out.println(i+" position in Fibonacci:"+fibonacciNumberArray[i]);
			}
		}
		return fibonacciNumberArray[n];
	}

	private static long lastDigitOfNthFibonacciNumber(int n) {
		if (n <= 1) {
			return n;
		}
		
		int previous = 0;
		int current = 1;		
		for (int i = 2; i < n-1; ++i) {
			int tmp_previous = previous;
			previous = current;
			current = (tmp_previous + current) % 10;
		}
		return current;

	}

}
