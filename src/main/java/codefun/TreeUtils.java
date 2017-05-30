package codefun;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

		public static void main(String[] args) {
			Node root = getDefaultTree();
			printTreeByLevel(root);
		}

		public static void printTreeByLevel(Node root) {
			if (root == null)
				return;

			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);

			// while queue is not empty
			while (queue.size() > 0) {
				// read first element
				Node current = queue.remove();

				if (current != null) {
					System.out.print(current.data);
					System.out.print(",");

					// push left child
					if (current.left != null)
						queue.add(current.left);

					// push right child
					if (current.right != null)
						queue.add(current.right);
				} else {
					System.out.println();
					// IMPORTANT: Add null only if the queue size is NOT zero
					if(queue.size() > 0)
						queue.add(null);
				}
			}

		}

		 static class Node {
			int data;
			Node left;
			Node right;

			Node(int data) {
				this.data = data;
			}
		}
	
		public static Node getDefaultTree() {
			Node root = new Node(1);
			Node two = new Node(2);
			Node three = new Node(3);
			Node four = new Node(4);
			Node five = new Node(5);
			Node six = new Node(6);
			Node seven = new Node(7);

			root.left = two;
			root.right = three;

			two.left = four;
			two.right = five;

			three.left = six;
			three.right = seven;
			return root;
		}
}
