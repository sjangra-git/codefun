package codefun;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalTree {

	private static boolean firstFound = false;
	private static boolean secondFound = false;
	private static TreeNode firstNode = null;
	private static TreeNode secondNode = null;
	private static TreeNode resultNode = null;
			
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		left.left = new TreeNode(3);		 
		
		firstNode = new TreeNode(2);
		secondNode = new TreeNode(3);
		
		firstCommonAncestor(root);
		System.out.println(resultNode.data);
	}
	
	private static void firstCommonAncestor(TreeNode node) {
		if(node == null) return;
		
		if(resultNode != null) return;
		
		if(firstNode.data == node.data) firstFound = true;
		
		if(secondNode.data == node.data) secondFound = true;
		
		firstCommonAncestor(node.left);
		
		if(resultNode != null) return;
		
		firstCommonAncestor(node.right);
		
		if(firstFound && secondFound) {
			resultNode = node;
		}
	}
	
	
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data) {
			this.data = data;
		}
	}
}
