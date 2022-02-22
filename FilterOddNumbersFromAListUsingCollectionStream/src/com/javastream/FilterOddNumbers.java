package com.javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FilterOddNumbers {

	public static void main(String[] args) {

		//Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//List<Integer> list = Arrays.asList(intArray);
		//or
		
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		

		FilterOddNumbers filterOddNumbers = new FilterOddNumbers();

		List<Integer> oddNumbers = filterOddNumbers.filterOddNumbers(list);
		System.out.println(oddNumbers);

	}

	public List<Integer> filterOddNumbers(List<Integer> list) {

		List<Integer> oddNumbers = list.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
		
		return oddNumbers;

	}

}
