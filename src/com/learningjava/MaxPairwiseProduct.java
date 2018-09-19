package com.learningjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class MaxPairwiseProduct {
	
	
	public static void main (String args[]) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProduct(numbers));	
		System.out.println(getMaxPairwiseProductFaster(numbers));
		
		/*int maxLengthOfSequence = scanner.nextInt();
		int maxNumberinSequence = scanner.nextInt();
		stressTest(maxLengthOfSequence, maxNumberinSequence);*/
	}
	
	static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {            	
                result = Math.max(result, (long)numbers[i] * numbers[j]);               
            }
        }
        return result;
    }
	
	static long getMaxPairwiseProductFaster(int[] numbers) {		
		
		int numbersLength = numbers.length;
		int largestNumberIndex = 0;		
		largestNumberIndex = findLargestNumberIndex(numbers, numbersLength, largestNumberIndex);
		
		swapNumbers(numbers, numbersLength, largestNumberIndex);	
		
		largestNumberIndex = 0;
		
		largestNumberIndex = findLargestNumberIndex(numbers, numbersLength-1, largestNumberIndex);
		
		swapNumbers(numbers, numbersLength-1, largestNumberIndex);	
		
		return (long)numbers[numbersLength-1] * numbers[numbersLength-2];		
	}

	// swap largest number with last number
	private static void swapNumbers(int[] numbers, int numbersLength, int largestNumberIndex) {		
		int swapLargestNumber = numbers[largestNumberIndex];
		numbers[largestNumberIndex] = numbers[numbersLength-1];
		numbers[numbersLength-1] = swapLargestNumber;
	}

	private static int findLargestNumberIndex(int[] numbers, int n, int largestNumberIndex) {
		for (int i = 1; i < n; i++) {
			if (numbers[i] > numbers[largestNumberIndex]) {
				largestNumberIndex = i;				
			}			
		}
		return largestNumberIndex;
	}
	
	static void stressTest(int firstNumber, int secondNumber ) {
		Random random = new Random();
		while (true) {
			int n = ThreadLocalRandom.current().nextInt(2, firstNumber+1);
			System.out.println("numbers range:"+n);
			int[] numbers = new int[n];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = random.nextInt(secondNumber+1);
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			
			long result1 = getMaxPairwiseProduct(numbers);
			long result2 = getMaxPairwiseProductFaster(numbers);
			if (result1 == result2) {
				System.out.println("OK");
			}
			else {
				System.out.println("Wrong Answer:"+result1+" "+result2);
				break;
			}
			
		}
	}
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	

}
