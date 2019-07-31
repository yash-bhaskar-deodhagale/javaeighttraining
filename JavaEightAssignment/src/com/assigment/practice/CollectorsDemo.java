package com.assigment.practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);
		
		// collect the result of a Stream into Set
		Set<Integer> intSet=numbers.stream().collect(Collectors.toSet());
		System.out.println("1.The result of a Stream into set :"+ intSet);
		
		// collect the result of a Stream into list
		List<Integer> intList=numbers.stream().collect(Collectors.toList());
		System.out.println("2.The result of a Stream into list :"+ intList);
		
		// create Map from the elements of Stream (first remove the duplicates)
		//Set<Integer> setwithoutDuplicate=numbers.stream().collect(Collectors.toSet(),);
		//System.out.println(setwithoutDuplicate);
		Map<Integer,Integer> map=numbers.stream().distinct().collect(Collectors.toMap(num->num, num->num));
		System.out.println("3.Map: "+map);
		
		//Map<Integer,Integer> map=setwithoutDuplicate.stream().collect(Collectors.toMap(num->num, num->num));
		//System.out.println("3.Map: "+map);

		
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics stats= numbers.stream().collect(Collectors.summarizingInt(number->number));
		System.out.println("4.Summary statistics:"+stats);
		
		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean,List<Integer>> map2=numbers.stream().collect(Collectors.partitioningBy(x->x%2==0));
		System.out.println("5.Map2"+ map2);
		
		// create comma separated string from numbers
		String commaSeperated=numbers.stream().map(num->num.toString()).collect(Collectors.joining(","));
		System.out.println("6.commaSeperated:"+commaSeperated);


	}
}
