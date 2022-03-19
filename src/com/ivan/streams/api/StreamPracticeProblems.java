package com.ivan.streams.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author Ivan
 * Java 8 Streams API useful problems relating to streams
 *
 */
public class StreamPracticeProblems {
	public static void main(String[] args) throws IOException {
		
		// Problem 1: Integer stream. Creates a stream of integers from 0 to 9 and it prints each element
		IntStream
			.range(0, 10)
			.forEach(System.out::print);
		System.out.println();
		
		//Problem 2: Integer stream and prints using lambda function, we use skip to skip an element from the range of streams created
		IntStream.range(1, 10)
			.skip(5)
			.forEach(x -> System.out.println(x));
		System.out.println();
		
		//Problem 3: Integer stream. Takes the sum of all elements from the stream
		Integer sum = IntStream.range(1, 10).sum();
		System.out.println(sum);
		
		//Problem 4: sorting elements of stream and find first
		Stream
			.of("Ivan", "Andres", "Claudia")
			.sorted()
			.findFirst()
			.ifPresent(name->System.out.println(name));
		
		//Problem 5: Filtering by first letter, sort them and print each element
		String[] names = {"Ayana", "Monica", "Andrea", "Alicia", "Petunia", "Veronica"};
		List<String> namesWithA = Arrays
			.stream(names)
			.filter(n -> n.startsWith("A"))
			.sorted()
			.collect(Collectors.toList());
		System.out.println(namesWithA.toString());
		
		//Problem 6: Average of squares
		Arrays
			.stream(new int[] {1,2,3,4,5,6})
			.map(num -> num*num)
			.average()
			.ifPresent(System.out::println);
		
		//Problem 7: Stream from List, filter, sort them and print
		List<String> namess = Arrays.asList("Abraham", "Alan", "Suriel", "Esteban", "Isaac");
		namess
			.stream()
			.map(String::toLowerCase)
			.filter(lowerName -> lowerName.startsWith("a"))
			.forEach(System.out::println);
		
		//Problem 8: Read from a file, sort, filter by bands larger than 13 characters
		Stream<String> bands = Files.lines(Paths.get("C:\\Users\\Ivan\\Desktop\\Revature\\Git Repos\\ProjectOnboarding\\src\\com\\ivan\\streams\\api\\bands.txt"));
		bands
			.sorted()
			.filter(b -> b.length() > 13)
			.forEach(System.out::println);
		bands.close();
		
		//Problem 9: 
	}
}
