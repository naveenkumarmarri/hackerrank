package com.practise.fun;

public class Solution {
	   public static void TreePrune(TreeNode root, int lower_bound, int upper_bound) {
		   if(root == null)
	            return;
		   if(root.left == null && root.right == null && (root.val <= lower_bound || root.val >= upper_bound))
	            root.val = null;
	            
	        if(root.left != null ) {
	                TreePrune(root.left, lower_bound, upper_bound);
	        }
	        if(root.right!= null) {
	                TreePrune(root.right, lower_bound, upper_bound);
	        }
	        
	        if(checkValid(root.left) || checkValid(root.right)) {
	            if(root.val <= lower_bound || root.val >=upper_bound)
	                root.val = null;   
	        }
	        
	        
	    }
	    
	   public static boolean checkValid(TreeNode root){

		   if( root == null || root.val == null)
	            return true;
			return false;
	    }
	    
	    public static void examineTree(TreeNode root) {
	        if (root != null) {
	            examineTree(root.left);
	            examineTree(root.right);
	            System.out.println(root.val);
	        }
	    }
	    
	   
	
	    public static void main(String[] args) {
	    	 TreeNode root = new TreeNode(6);
	         root.left = new TreeNode(7);
	         root.right = new TreeNode(1);
	         root.left.left = new TreeNode(13);
	         root.left.right = new TreeNode(9);
	         root.right.right = new TreeNode(2);
	   
	  
	        TreePrune(root, 7, 10);
	        examineTree(root);
	    }
	    

}
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) { val = x; }
}

 