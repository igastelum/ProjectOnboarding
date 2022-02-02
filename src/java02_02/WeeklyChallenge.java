package java02_02;

/**
 * 
 * @author Ivan Gastelum
 * 
 *         1) A pronic number (or otherwise called as heteromecic) is a number
 *         which is a product of two consecutive integers, that is, a number of
 *         the form n(n + 1). Create a function that determines whether a number
 *         is pronic or not.
 * 
 *         Examples: isHeteromecic(0) ➞ true 0 (0 + 1) = 0 1 = 0
 *         isHeteromecic(2) ➞ true 1 (1 + 1) = 1 2 = 2 isHeteromecic(7) ➞ false
 *         isHeteromecic(110) ➞ true 10 (10 + 1) = 10 11 = 110
 *         isHeteromecic(136) ➞ false isHeteromecic(156) ➞ true
 * 
 * 
 *         2) Given any number, we can create a new number by adding the sums of
 *         squares of digits of that number. For example, given 203, our new
 *         number is 4 + 0 + 9 = 13. If we repeat this process, we get a
 *         sequence of numbers:
 * 
 *         203 -> 13 -> 10 -> 1 -> 1
 * 
 *         Sometimes, like with 203, the sequence reaches (and stays at) 1.
 *         Numbers like this are called happy. Not all numbers are happy. If we
 *         started with 11, the sequence would be: 11 -> 2 -> 4 -> 16 -> ...
 *         This sequence will never reach 1, and so the number 11 is called
 *         unhappy. Given a positive whole number, you have to determine whether
 *         that number is happy or unhappy.
 * 
 *         Examples: happy(203) ➞ true happy(11) ➞ false happy(107) ➞ false
 * 
 *         Notes: You can assume (and it is actually true!) that all positive
 *         whole numbers are either happy or unhappy. Any happy number will have
 *         a 1 in its sequence, and every unhappy number will have a 4 in its
 *         sequence. The only numbers passed to your function will be positive
 *         whole numbers.
 */

public class WeeklyChallenge {
	public static void main(String[] args) {

		// Problem 1: Testing several integers if isHeteromecic
		System.out.println("Number 0 ->" + isHeteromecic(0));
		System.out.println("Number 2 ->" + isHeteromecic(2));
		System.out.println("Number 7 ->" + isHeteromecic(7));
		System.out.println("Number 110 ->" + isHeteromecic(110));
		System.out.println("Number 136 ->" + isHeteromecic(136));
		System.out.println("Number 156 ->" + isHeteromecic(156));
		
		System.out.println();

		// Problem 2:
		System.out.println("203 ->" + happy(203));
		System.out.println("11 ->" + happy(11));
		System.out.println("107 ->" + happy(107));
		System.out.println("7 ->" + happy(7));
	}

	public static boolean isHeteromecic(int n) {
		int a = 0, b = 1;
		int result = a * b;
		while (result <= n) {
			if (result == n)
				return true;
			else {
				a = a + 1;
				b = a + 1;
				result = a * b;
			}
		}
		return false;
	}

	public static boolean happy(int n) {
		int result = n;
		System.out.print(n + " -> ");
		while (result != 4) {
			int sum = 0;
			n = result;
			while (n != 0) {
				int digit = n % 10;
				sum = sum + (digit * digit);
				n = n / 10;
			}
			result = sum;
			System.out.print(result + " -> ");
			if(result==1) return true;
		}
		System.out.println();
		return false;
	}
}
