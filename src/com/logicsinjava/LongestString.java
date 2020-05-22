package com.logicsinjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestString {

	public static void main(String[] args) {

		
		String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
		
		Stream.of(allLongestStrings(inputArray)).forEach(System.out::println);
		
	}

	static String[] allLongestStrings(String[] inputArray) {
		return Stream.of(inputArray)
				.filter(x -> x.length() == Collections.max((new ArrayList<String>(Arrays.asList(inputArray))).stream()
						.map(a -> a.length()).collect(Collectors.toList())))
				.toArray(String[]::new);
	}

}
