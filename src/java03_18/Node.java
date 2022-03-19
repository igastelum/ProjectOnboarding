package java03_18;

public class Node {
	Node next;
	private int data;
	
	Node(int number){
		data = number;
		next = null;
	}
	
	public int getData() {
		return data;
	}
}
