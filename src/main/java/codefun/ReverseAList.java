package codefun;

/**
 * reverse a singly linked list in linear time.
 * @author sjangra
 *
 */
public class ReverseAList {

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = null;
		
		System.out.println("Reversing the string");
		Node rev = reverse(a);
		Node curr = rev;
		
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	private static Node reverse(Node root) {
		Node rRoot = null;
		
		rRoot = _reverse(root);
		return rRoot;
	}
	
	private static Node _reverse(Node root) {
		Node rRoot = null;
		
		Node curr = root;
		Node prev = null;
		Node next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			rRoot = prev;
		}
		
		return rRoot;
	}
	
	private static Node reverse1(Node root) 
	{
	    Node curr = root;
	    Node prev = null;
	    Node prevToPrev = null;
	    
	    while(curr != null)
	    {
	        // Swap the next pointer to move to previous node
	        if(prev != null)
	        {
	            prev.next = prevToPrev;
	        }
	        
	        prevToPrev = prev;
	        prev = curr;
	        curr = curr.next;
	    }
	    
	    prev.next = prevToPrev;
	    return prev;
	}
	
	private static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
 }

