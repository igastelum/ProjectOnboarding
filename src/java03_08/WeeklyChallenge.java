package java03_08;

import java.math.BigInteger;

/**
 * 
 * @author Ivan
 * Each new term in the Fibonacci sequence is generated by adding the previous 
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 *
 */

public class WeeklyChallenge {

	public static void main(String[] args) {
		System.out.println("Even terms sum: " + evenFib(4000000));
	}
	
	public static BigInteger evenFib(int limit) {
		long [] lastTwo = {0,1};
		BigInteger sum = new BigInteger("0");
		int counter = 0;
		while(lastTwo[1] <= limit) {
			if(lastTwo[1]%2==0) sum = sum.add(BigInteger.valueOf(lastTwo[1]));
			long nextFib = lastTwo[0] + lastTwo[1];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = nextFib;
			counter++;
		}
		System.out.println(counter + "th number in the fibonacci sequence is: " + lastTwo[0]);
		System.out.println("Last number before exceeding 4,000,000 limit");
		return sum;
	}
}
