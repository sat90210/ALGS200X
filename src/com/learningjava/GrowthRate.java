package com.learningjava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrowthRate {
	
	private static String getGrowthRate(int nValue) {
		
		Map<Integer, Double> functions = new HashMap<>();		
		
		Double value = Math.pow(nValue, 3);
		functions.put(1, value);
		value = Math.pow(nValue, 0.3);
		functions.put(2, value);
		value = Double.valueOf(nValue);
		functions.put(3, value);
		value = Math.sqrt(nValue); 
		functions.put(4, value);
		value = Math.pow(nValue, 2)/ Math.sqrt(nValue);
		functions.put(5, value);
		value = Math.pow(nValue, 2);
		functions.put(6, value);
		
		Map<Integer, Double> result = functions.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		List<Double> orderedValues = functions.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
				
		int index = 1;		
		
		return "";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(getGrowthRate(n));

	}

}
