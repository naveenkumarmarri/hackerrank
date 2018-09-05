package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VerticalOrderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        if(root == null)
	            return list;
	        int min = 0;
	        int max = 0;
	        HashMap<Integer, ArrayList<Integer>> hdMap = new HashMap<Integer, ArrayList<Integer>>();
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        Queue<Integer> cols = new LinkedList<Integer>();
	        queue.offer(root);
	        cols.offer(0);
	        hdMap.computeIfAbsent(0, k->new ArrayList<Integer>()).add(root.val);
	        //hdMap.put(0, root.val);
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            for(int i=0; i<size; i++) {
	                TreeNode polledNode = queue.peek();
	                int hd = cols.peek();
	                if(polledNode.left != null)  {
	                    queue.offer(polledNode.left);
	                    cols.offer(hd - 1);
	                    min = Math.min(min, hd- 1);  
	                    hdMap.computeIfAbsent(hd - 1, k-> new ArrayList<Integer>()).add(polledNode.left.val);
	                    
	                }
	                if(polledNode.right != null) {
	                    queue.offer(polledNode.right);
	                    cols.offer(hd + 1);
	                    max = Math.max(max, hd + 1);
	                    hdMap.computeIfAbsent(hd + 1, k-> new ArrayList<Integer>()).add(polledNode.right.val);
	                }
	                queue.poll();
	                cols.poll();
	            }
	        }
	        for(int i = min; i<= max; i++) {
	            list.add(hdMap.get(i));
	        }
	        return list;
	    }
	
}
