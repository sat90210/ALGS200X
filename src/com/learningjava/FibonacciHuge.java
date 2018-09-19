package com.learningjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {
	private static long getFibonacciHugeNaive(long n, long m) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;

		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		return current % m;
	}
	
	
	private static long pisanoNaive(long modulo) {
		long previous = 1;
		long current = 1;		
		long result = 1;
		
		while (!(previous == 0 && current ==1)) {
			long buffer = (previous + current) % modulo;
			previous = current;
			current = buffer;					
		}
		
		result += 1;
		return result;		
	}
	
	private static long getFibonacciHugeFast(long number, long modulo) {
		
		// Store moduloes only in one pisano period
		List<Long> modulos = new ArrayList<>();
		modulos.add(new Long(0));
		modulos.add(new Long(1));
		int i = 0;
		
		// Check current and next modulo
		while(!(i > 0 && modulos.get(i).longValue() == 0 && modulos.get(i+1).longValue() == 1)) {
			long tempModulo = ((modulos.get(i).longValue() % modulo + modulos.get(i+1).longValue() % modulo) % modulo);
			modulos.add(new Long(tempModulo));
			i++;
		}		
		// i is the current pisano period, loop to Fnumber % i again
		System.out.println("Pisano Period:" + i);
		return modulos.get( (int) (number % i));
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		
		//System.out.println(getFibonacciHugeNaive(n, m));
		System.out.println(getFibonacciHugeFast(n, m));
	}
}
