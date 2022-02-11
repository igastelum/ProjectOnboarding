package java02_07;

import java.util.Arrays;

/**
 * 
 * @author Ivan 
 * 1) Write a function that returns true if a string consists of
 *         ascending or ascending AND consecutive numbers. Examples
 *         ascending("232425") --> true Consecutive numbers 23, 24, 25
 *         ascending("2324256") --> false No matter how this string is divided,
 *         the numbers are not consecutive. ascending("444445") --> true
 *         Consecutive numbers 444 and 445.
 * 
 *         Notes A number can consist of any number of digits, so long as the
 *         numbers are adjacent to each other, and the string has at least two
 *         of them.
 *
 *2) Create a function that takes an integer and outputs an n x n
 *         square solely consisting of the integer n. Examples squarePatch(3)
 *         --> [ [3, 3, 3], [3, 3, 3], [3, 3, 3] ] squarePatch(5) --> [ [5, 5,
 *         5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5,
 *         5, 5, 5] ] squarePatch(1) --> [ [1] ] squarePatch(0) --> [] Notes n
 *         >= 0. If n = 0, return an empty array.
 * 
 *3) Write a function that finds the sum of an array. Make your
 *         function recursive. Examples sum([1, 2, 3, 4]) ➞ 10sum([1, 2]) ➞
 *         3sum([1]) ➞ 1sum([]) ➞ 0 Notes Return 0 for an empty array.
 */
public class WeeklyCodingChallenge {
	public static void main(String[] args) {

		// Testing ascending method
		System.out.println("232425 -> " + ascending("232425"));
		System.out.println("2324256 -> " + ascending("2324256"));
		System.out.println("444445 -> " + ascending("444445"));

		// Testing squarePatch
		System.out.println("Square patching 3: " + Arrays.deepToString(squarePatch(3)));
		System.out.println("Square patching 5: " + Arrays.deepToString(squarePatch(5)));
		System.out.println("Square patching 1: " + Arrays.deepToString(squarePatch(1)));
		System.out.println("Square patching 0: " + Arrays.deepToString(squarePatch(0)));
		
		//Teting resursive method of Sum
		int [] array0 = {1,2,3};
		System.out.println("[1,2,3] -> " + sum(array0));
		int [] array1 = {};
		System.out.println("[ ] -> " + sum(array1));
		int [] array2 = {1};
		System.out.println("[1] -> " + sum(array2));
		int [] array3 = {46,54,98,32,5,87,12};
		System.out.println("[46,54,98,32,5,87,12] -> " + sum(array3));
	}

	public static boolean ascending(String str) {
		if (str.length() == 1)
			return false;

		int partition = 2;
		while (partition < str.length()) {
			if (str.length() % partition == 0) {
				// Then we can begin partitioning the String
				int[] numbers = partition(str, partition);
				if (ascendingAndConsecutiveCheck(numbers))
					return true;
				else
					partition++;
			} else
				partition++;
		}
		return false;
	}

	public static int[] partition(String str, int partition) {
		int begin = 0, last = partition;
		int[] nums = new int[str.length() / partition];
		int index = 0;
		while (last <= str.length()) {
			String number = str.substring(begin, last);
			//System.out.println(number);
			nums[index] = Integer.parseInt(number);
			begin = last;
			last = last + partition;
			index++;
		}
		//System.out.println(Arrays.toString(nums));
		return nums;
	}

	public static boolean ascendingAndConsecutiveCheck(int[] array) {
		if (array.length == 1)
			return false;
		for (int i = 1; i < array.length; i++) {
			if ((array[i] - 1) != array[i - 1])
				return false;
		}
		return true;
	}

	public static int[][] squarePatch(int n) {
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = n;
			}
		}
		return matrix;
	}
	
	public static int sum(int [] array) {
		if(array.length==0)
			return 0;
		else {
			return array[array.length-1] + sum(Arrays.copyOf(array, array.length-1));
		}
	}
	
}
