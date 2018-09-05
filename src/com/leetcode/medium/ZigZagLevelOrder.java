package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        if(root == null)
	            return list;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        int level = 1;
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            List<Integer> nodesAtLevel = new ArrayList<Integer>();
	            for(int i=0; i<size; i++) {              
	                TreeNode polledNode = queue.peek();
	                if(polledNode.left != null) queue.offer(polledNode.left);
	                if(polledNode.right != null) queue.offer(polledNode.right);
	                nodesAtLevel.add(polledNode.val);
	                queue.poll();
	            }
	            if(level % 2 == 0)
	                Collections.reverse(nodesAtLevel);
	            list.add(nodesAtLevel);
	            level += 1;
	        }
	        return list;
	    }
	
}
