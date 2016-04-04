package codefun;

/**
 * Find if two trees are mirror images of each other.
 * 
 * In a mirror image left becomes right and right becomes left.
 * So if we traverse the tree such that we move left for first tree, and right for second tree then the nodes should
 * be same, in case of mirror images.
 * 
 * If at any time, the current node is not same or only one of the node is null then it is not a mirror image.
 *
 */
public class MirrorImage {

	public static void main(String[] args) {
		Node node1 = new Node('a');
		node1.left = new Node('b');
		node1.right = new Node('c');

		Node node2 = new Node('a');
		node2.left = new Node('c');
		node2.right = new Node('b');

		System.out.println(isImage(node1, node2));
	}

	private static boolean isImage(Node node1, Node node2) {

		// If both nodes null then return false
		if (node1 == null || node2 == null)
			return false;

		// Compare the two nodes, they should be same
		if (node1.data != node2.data)
			return false;

		// If we are here, this means the current nodes data is same
		// Now compare the left node of 1st tree with right node of second tree
		boolean result1;

		// Check left arm of first tree and right arm of second tree
		// Recurse only if both of them are not null.
		if (node1.left != null && node2.right != null) {
			result1 = isImage(node1.left, node2.right);
		} else if (node1.left == null && node2.left == null) {
			// Both are null, this means node1 and node2 are the leaf nodes in
			// the respective trees. return true
			return true;
		} else {
			// Only one of them is null - return false.
			return false;
		}

		// Now if left arm returned true, check the right arm of first tree
		// against left arm of second tree
		boolean result2;
		if (result1) {
			if (node1.right != null && node2.left != null) {
				result2 = isImage(node1.right, node2.left);
			} else if (node1.right == null && node2.left == null) {
				return true;
			} else {
				return false;
			}
		} else {
			result2 = result1;
		}

		return result2;
	}

	private static class Node {

		char data;
		Node left;
		Node right;

		Node(char data) {
			this.data = data;
		}
	}
}
