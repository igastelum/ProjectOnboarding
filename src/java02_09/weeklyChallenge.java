package java02_09;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 
 * @author Ivan 
 * 1) Create a function that takes an array of more than three
 *         numbers and returns the Least Common Multiple (LCM).
 * 
 *         Examples: lcmOfArray([5, 4, 6, 46, 54, 12, 13, 17]) ➞ 2744820
 * 
 *         lcmOfArray([46, 54, 466, 544]) ➞ 78712992
 * 
 *         lcmOfArray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]) ➞ 2520
 * 
 *         lcmOfArray([13, 6, 17, 18, 19, 20, 37]) ➞ 27965340
 * 
 *         Notes: The LCM of an array of numbers is the smallest positive number
 *         that is divisible by each of the numbers in the array.
 * 
 *2) Given an integer value, return a new integer according to the
 *   rules below:
 * 
 *         -Split the number into groups of two digit numbers. If the number has
 *         an odd number of digits, return -1. -For each group of two digit
 *         numbers, concatenate the last digit to a new string the same number
 *         of times as the value of the first digit. -Return the result as an
 *         integer.
 * 
 *         lookAndSay(3132) ➞ 111222
 * 
 *         // By reading the number digit by digit, you get three "1" and three
 *         "2". // Therefore, you put three ones and three two's together. //
 *         Remember to return an integer value (i.e BigIntger class). Examples:
 *         1) lookAndSay(1213200012171979) ➞ 23002799999999
 * 
 *         2) lookAndSay(54544666) ➞ 44444444446666666666
 * 
 *         3) lookAndSay(95) ➞ 555555555
 * 
 *         4) lookAndSay(1213141516171819) ➞ 23456789
 * 
 *         5) lookAndSay(120520) ➞ 200
 * 
 *         6) lookAndSay(231) ➞ -1
 * 
 *         Notes: Note that the number 0 can be included (see example #5).
 * 
 */

public class weeklyChallenge {

	public static void main(String[] args) {
		
		//To test lcmOfArray method
		int [] array0 = {1,2,8,3};
		System.out.println("Least Commmon Multiple from " + Arrays.toString(array0) + " -> " +  lcmOfArray(array0));
		int [] array1 = {5, 4, 6, 46, 54, 12, 13, 17};
		System.out.println("Least Commmon Multiple from " + Arrays.toString(array1) + " -> " +  lcmOfArray(array1));
		int [] array2 = {46, 54, 466, 544};
		System.out.println("Least Commmon Multiple from " + Arrays.toString(array2) + " -> " +  lcmOfArray(array2));
		int [] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Least Commmon Multiple from " + Arrays.toString(array3) + " -> " +  lcmOfArray(array3));
		
		
		//Testing lookAndSay method
		System.out.println("96 -> " + lookAndSay(96l));
		System.out.println("1213200012171979 -> " + lookAndSay(1213200012171979l));
		System.out.println("54544666 -> " + lookAndSay(54544666l));
		System.out.println("120520 -> " + lookAndSay(120520l));
		System.out.println("231 -> " + lookAndSay(231l));
	}
	
	public static int lcmOfArray(int[] array) {
		
		int lcm = 1;
		boolean isDivisible;
		int divisor = 2;
		
		while(true) {
			isDivisible = false;
			int counter = 0;
			for(int i=0; i<array.length; i++) {
				if(array[i]==0) return 0;
				
				if(array[i]==1) counter++;
				
				if(array[i]<0)
					array[i] = array[i] *-1;
				
				if(array[i]%divisor==0) {
					array[i] = array[i] / divisor;
					isDivisible = true;
				}
			}
			if(isDivisible) {
				lcm = lcm * divisor;
			}else divisor++;
			
			if(array.length==counter)
				return lcm;
		}
	}
	
	public static BigInteger lookAndSay(long i) {
		
		if(i<10) return new BigInteger("0");
		else {
			String finalNum = "";
			while(i>=10) {
				long num = i%10;
				i = i/10;
				long times = i%10;
				i = i/10;
				finalNum = appendVal(times, num) + finalNum;
				if(i>0 && i<10) 
					return new BigInteger("-1");
			}
			return new BigInteger(finalNum);
		}
	}
	
	
	public static String appendVal(long times, long num) {
		String str = "";
		while(times>0) {
			str = str + String.valueOf(num);
			times--;
		}
		return str;
	}
}
