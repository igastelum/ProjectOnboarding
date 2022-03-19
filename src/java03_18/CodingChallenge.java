package java03_18;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Ivan
 * 1) Given two singly linked lists that intersect at some point, find the intersecting node. Assume the lists are non-cyclical.
 * 
 * 		For example, given A = 3 ➔ 7 ➔ 8 ➔ 10 and B = 99 ➔ 1 ➔ 8 ➔ 10, 
 * 		return the node with value 8. In this example, assume nodes with the same value 
 * 		are the exact same node objects.
 * 
 * Do this in 0( m + n) time (where m and n are the lengths of the lists) and constant space.
 * 
 * 2) Implement a stack that has the following methods:
 * • push ( val ) : push val onto the stack
 * • pop: pop off and return the topmost element of the stack. If there are no elements in the stack, throw an error.
 * • max: return the maximum value in the stack currently. If there are no elements in the stack, throw an error.
 * 
 * 		Each method should run in constant time.
 *
 */
public class CodingChallenge {

	public static void main(String[] args) {
		Node n1 = new Node(3);
		LinkedList A = new LinkedList(n1);
		Node n2 = new Node(7);
		Node n3 = new Node(8);
		Node n4 = new Node(10);
		
		A.head.next = n2;
		A.head.next.next = n3;
		A.head.next.next.next = n4;
		
		Node n5 = new Node(99);
		LinkedList B = new LinkedList(n5);
		Node n6 = new Node(1);
		
		B.head.next = n6;
		B.head.next.next = n3;
		B.head.next.next.next = n4;
		
		A.printList();
		B.printList();
		
		Node result = intersectCheck(A,B);
		if(result==null) System.out.println("No intersection");
		else System.out.println("Intersection at node -> " + result.getData());
		
		//---------------------------------SECOND---------------------------------------------
		
		Node s1 = new Node(4);
		Node s2 = new Node(7);
		Node s3 = new Node(32);
		Node s4 = new Node(66);
		Stack stack = new Stack(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		System.out.println("Top node of stack is: " + stack.top.getData());
		stack.printStack();
		stack.pop();
		System.out.println("Top node of stack is: " + stack.top.getData());
		stack.printStack();
		System.out.println("Max value is: " + stack.max());
	}

	//Worst time complexity is O(m + n)
	public static Node intersectCheck(LinkedList A, LinkedList B) {
		
		Set<Node> visited = new HashSet<Node>();
		Node temp1 = A.head;
		Node temp2 = B.head;
		
		while(temp1!=null) {
			visited.add(temp1);
			temp1 = temp1.next;
		}
		
		while(temp2!=null) {
			if(visited.contains(temp2)) {
				return temp2;
			} else {
				temp2 = temp2.next;
			}
		}
		return null;
	}
	
}
