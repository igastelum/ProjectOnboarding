package java03_18;

public class LinkedList {
	Node head;
	
	LinkedList(Node head){
		this.head = head;
	}
	
	void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.getData() + " -> ");
			temp = temp.next;
		}
		System.out.println(" null");
	}
}
