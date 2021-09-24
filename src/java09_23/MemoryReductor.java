package java09_23;

public class MemoryReductor {

	/**
	 * Create a function that takes the memory size (ms is a string type) as an argument and returns the actual memory size.
	 * Examples
	 * 		actualMemorySize("32GB") --> "29.76GB"
	 * 		actualMemorySize("2GB") --> "1.86GB"
	 * 		actualMemorySize("512MB") --> "476MB"
	 * 
	 * Notes
	 * 		-The actual storage loss on a USB device is 7% of the overall memory size!
	 * 		-If the actual memory size was greater than 1 GB, round your result to two decimal places.
	 * 		-If the memory size after adjustment is smaller then 1 GB, return the result in MB.
	 * 
	 */
	public static void main(String[] args) {
		
		String test1 = "32GB";
		String test2 = "2GB";
		String test3 = "512MB";
		String test4 = "1GB";
		String test5 = "-45KB";
		String test6 = "46198";
		String test7 = "WEQESAD";
		
		try {
			System.out.println("32GB -> Actual memory: " + actualMemorySize(test1));
			System.out.println("2GB -> Actual memory: " + actualMemorySize(test2));
			System.out.println("512MB -> Actual memory: " + actualMemorySize(test3));
			System.out.println("1GB -> Actual memory: " + actualMemorySize(test4));
			System.out.println("-45KB -> Actual memory: " + actualMemorySize(test5));
			System.out.println("46198 -> Actual memory: " + actualMemorySize(test6));
			System.out.println("WEQESAD -> Actual memory: " + actualMemorySize(test7));
		} catch (NumberFormatException e) {
			System.out.println("INVALID INPUT, NUMBER FORMAT EXCEPTION CAUGHT");
		}
		
	}

	private static String actualMemorySize(String size) throws NumberFormatException{
		if(size.length()<=2)
			return "NOT A VALID INPUT";
		
		String memoryUnit = size.substring(size.length()-2, size.length());
		String memoryVal = size.substring(0, size.length()-2);
		double memoryValue = Double.valueOf(memoryVal);
		
		//Catch negative values
		if(memoryValue<0)
			return "NEGATIVE VALUE CAUGHT";
		
		
		if(memoryUnit.equals("GB") || memoryUnit.equals("TB")) {
			double actualMemory = (double)memoryValue - ((double)memoryValue * 7.0)/100;
			if(actualMemory<1.0 && memoryUnit.equals("GB")) {
				memoryUnit = "MB";
				actualMemory = actualMemory * 1000;
			}
			if(actualMemory<1.0 && memoryUnit.equals("TB")) {
				memoryUnit = "GB";
				actualMemory = actualMemory * 1000;
			}
			double roundedResult = Math.round(actualMemory*100.0)/100.0;
			return Double.toString(roundedResult) + memoryUnit;
		}
		
		if((memoryUnit.equals("MB") || memoryUnit.equals("KB"))) {
			double actualMemory = (double)memoryValue - ((double)memoryValue * 7.0)/100;
			Double roundedResult = (double) (Math.round(actualMemory*100.0)/100.0);
			return roundedResult.toString() + memoryUnit;
		}
			
		return "INVALID INPUT";
	}

}
