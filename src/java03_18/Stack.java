package java03_18;

public class Stack {
	
	Node bottom;
	Node top;
	
	Stack(Node n){
		bottom = n;
		top = n;
	}
	
	void push(Node n) {
		if(bottom==null) {
			bottom = n;
			top = n;
		}
		
		if(bottom.equals(top)) {
			top = n;
			bottom.next = top;
		}else {
			Node temp = top;
			top = n;
			temp.next = top;
		}
	}
	
	Node pop() {
		if(bottom==null)
			return null;
		if(bottom.next==null) {
			Node temp = bottom;
			bottom = null;
			top = null;
			return temp;
		}
		
		Node temp = bottom;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		
		Node popped = temp.next;
		temp.next = null;
		top = temp;
		return popped;
	}
	
	int max() {
		int maxVal = -1;
		Node temp = bottom;
		while(temp!=null) {
			if(maxVal<temp.getData())
				maxVal = temp.getData();
			temp = temp.next;
		}return maxVal;
	}
	
	void printStack() {
		Node temp = bottom;
		while(temp!=null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.next;
		}
		System.out.println(" null");
	}
}
