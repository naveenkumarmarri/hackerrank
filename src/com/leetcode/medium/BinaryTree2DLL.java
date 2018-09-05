package com.leetcode.medium;

import java.util.ArrayList;

public class BinaryTree2DLL {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = null;
		root.right.right = new TreeNode(6);
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		flatten_(root);
//		for(int i=0;i<nodes.size();i++) {
//			if(i == nodes.size() - 1)
//				nodes.get(i).right = null;
//			else
//				nodes.get(i).right = nodes.get(i+1);
//		}
//		for(int i=nodes.size()-1;i>=0;i--) {
//			if(i == 0)
//				nodes.get(i).left = null;
//			else
//				nodes.get(i).left= nodes.get(i-1);
//		}
		TreeNode left_ = root;
		while(left_.right != null) {
			System.out.println(left_.val);
			left_ = left_.right;
		}
		System.out.println("----------");
		while(left_ != null) {
			System.out.println(left_.val);
			left_ = left_.left;
		}
	}
	public static void flatten(TreeNode root, ArrayList<TreeNode> nodes) {
		if(root == null)
			return;
		nodes.add(root);
		flatten(root.left, nodes);
		flatten(root.right, nodes);
		
	}
	
	private static TreeNode prev = null;

	public static void flatten_(TreeNode root) {
	    if (root == null)
	        return;
	    flatten_(root.right);
	    flatten_(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}

}

