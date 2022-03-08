package java03_02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @author Ivan
 * 
 * Create a function that takes one, two or more numbers as arguments and 
 * adds them together to get a new number. The function then repeatedly 
 * multiplies the digits of the new number by each other, yielding anew 
 * number, until the product is only 1 digit long. Return the final product.
 * 
 * Examples:
 * sumDigProd(16, 28) -> 6
 * 		16 + 28 = 44
 * 		4 * 4 = 16
 * 		1 * 6 = 6
 * 
 * sumDigProd(0) -> 0
 * 	
 * sumDigProd(1, 2, 3, 4, 5, 6) -> 2
 * 		1 + 2 + 3 + 4 + 5 + 6 = 21
 * 		2 * 1 = 2
 *
 */
public class WeeklyChallenge {
	public static void main(String[] args) {
		System.out.println("[1,2,3,4,5,6] -> " + sumDigProd(1,2,3,4,5,6));
		System.out.println("[0] -> " + sumDigProd(0));
		System.out.println("[16,28] ->" + sumDigProd(16,28));
	}
	
	public static Integer sumDigProd(int...numbers) {
		
		List<Integer> boxNums = IntStream.of(numbers).boxed().collect(Collectors.toList());
		Integer sum = boxNums.stream().reduce(0, Integer::sum);
		if(sum.equals(0)) return 0;
		
		Integer result;
		while(true) {
			result = 1;
			while(sum>0) {
				Integer digit = sum%10;
				result *= digit;
				sum /=10;
			}
			if(result<10) break;
			else sum = result;
		}
		return result;
	}
}
