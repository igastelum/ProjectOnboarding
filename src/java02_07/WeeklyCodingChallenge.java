package java02_07;

import java.util.Arrays;

/**
 * 
 * @author Ivan 
 * 1) Write a function that returns true if a string consists of
 * ascending or ascending AND consecutive numbers. 
 *         Examples
 *         ascending("232425") --> true
 *         Consecutive numbers 23, 24, 25
 *         ascending("2324256") --> false
 *         No matter how this string is
 *         divided, the numbers are not consecutive. ascending("444445") --> true
 *         Consecutive numbers 444 and 445. 
 *         
 *         Notes A number can consist
 *         of any number of digits, so long as the numbers are adjacent to each
 *         other, and the string has at least two of them.
 *
 *2) Create a function that takes an integer and outputs an n x n
 *square solely consisting of the integer n. Examples squarePatch(3)
 *         --> [ [3, 3, 3], [3, 3, 3], [3, 3, 3] ] squarePatch(5) --> [ [5, 5,
 *         5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5,
 *         5, 5, 5] ] squarePatch(1) --> [ [1] ] squarePatch(0) --> [] Notes n
 *         >= 0. If n = 0, return an empty array.
 */
public class WeeklyCodingChallenge {
	public static void main(String[] args) {
		
		//Testing squarePatch
		System.out.println(Arrays.deepToString(squarePatch(3)));
		System.out.println(Arrays.deepToString(squarePatch(5)));
		System.out.println(Arrays.deepToString(squarePatch(1)));
		System.out.println(Arrays.deepToString(squarePatch(0)));
	}
	
	public static boolean ascending(String str) {
		if(str.length()==1) return true;
		
		int partition = str.length();
		while(partition>=1) {
			if(str.length()%2==0) {
				
			}else {
				int [] nums = partition(str.split(""), str.length());
				if(ascendingAndConsecutiveCheck(nums)) return true; 
				else return false;
			}
			//partition = partition
		}
		return false;
	}
	
	public static int[] partition(String[] str, int partition) {
		int [] nums = new int[partition];
		for(int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		return nums;
	}
	
	public static boolean ascendingAndConsecutiveCheck(int [] array) {
		
		if (array.length==1) return false;
		for(int i=1; i<array.length;i++) {
			if((array[i] - 1) != array[i-1]) return false;
		}
		return true;
	}
	
	public static int[][] squarePatch(int n) {
		int [][] matrix = new int [n][n];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				matrix[i][j] = n;
			}
		}
		return matrix;
	}
}
