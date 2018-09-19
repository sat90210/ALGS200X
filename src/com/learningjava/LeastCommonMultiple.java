package com.learningjava;

import java.util.Scanner;

public class LeastCommonMultiple {

	private static long lcm_naive(int a, int b) {
		for (long l = 1; l <= (long) a * b; ++l)
			if (l % a == 0 && l % b == 0)
				return l;

		return (long) a * b;
	}
	
	private static long lcm_improved(int a, int b) {		
		return ((long)a * b)/gcd_euclid(a, b);				
	}
	
	private static long gcd_euclid(int a, int b) {		
		if (b == 0) {
			return a;
		}
		return gcd_euclid(b, a % b);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		//System.out.println(lcm_naive(a, b));
		System.out.println(lcm_improved(a, b));

	}
}
