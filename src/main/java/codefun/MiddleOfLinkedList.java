package codefun;

/**
 * Find middle element of single linked list in one pass.
 * 
 * Idea is to have two pointers p1 and p2. p2 moves at twice the speed of p1.
 * When p2 reaches end, p1 will be at the middle of the list.
 * @author sjangra
 *
 */
public class MiddleOfLinkedList {

	public static void main(String[] args) {
	 
	}
	
	private static int findMiddle(Node start) {
		if(start == null) return -1;
		
		if(start.next == null || start.next.next == null) return start.data;
		
		Node p1 = start;
		Node p2 = start.next.next;
		
		while(p2.next != null || p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		if(p2.next == null) 
			return p1.data;
		else		
			return p1.next.data;				 
	}
	
	private static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
}
