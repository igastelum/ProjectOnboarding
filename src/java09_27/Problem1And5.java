package java09_27;

public class Problem1And5 {
	
	/**
	 * 
	 * 1.) Write a Java Program to swap two numbers without using the third variable.
	 * 
	 * 5.) We are given N items which are of total K different colors. 
	 * Items of the same color are indistinguishable and colors can be numbered 
	 * from 1 to K and count of items of each color is also given as k1, k2 and so on. 
	 * Now we need to arrange these items one by one under a constraint that the last 
	 * item of color i comes before the last item of color (i + 1) for all possible 
	 * colors. Our goal is to find out how many ways this can be achieved.
	 * 
	 */

	public static void main(String[] args) {
		
		//Problem 1. Testing
		int x = 4, y = 5;
		System.out.println(x + " & " + y + " Swap: " + swapNumbers(x,y)[0] + "," + swapNumbers(x,y)[1]);
		x = -1; y = 6;
		System.out.println(x + " & " + y + " Swap: " + swapNumbers(x,y)[0] + "," + swapNumbers(x,y)[1]);
		
		//Problem 5. Testing
		
	}
	
	public static int[] swapNumbers(int x, int y) {
		x = x + y;
		y = x - y;
		x = x - y;
		int [] arr = {x,y};
		return arr;
	}

}
