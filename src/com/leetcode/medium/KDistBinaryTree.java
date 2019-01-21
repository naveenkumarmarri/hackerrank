package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDistBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	        List<Integer> list = new ArrayList<Integer>();
	        HashSet<TreeNode> visited = new HashSet<TreeNode>();
	        if(root == null)
	            return list;
	        HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        Queue<Integer> dist = new LinkedList<Integer>();
	        dfs(root, map, null);
	        if(!map.containsKey(target))
	            return list;
	        queue.offer(target);
	        dist.offer(0);
	        while(!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            int dist_ = dist.poll();
	            if(!visited.contains(node)) {
	                if(dist_ == K) {
	                    list.add(node.val);
	                }
	                if(node.left != null) {
	                    queue.offer(node.left);
	                    dist.offer(dist_+1);
	                }
	                if(node.right != null) {
	                    queue.offer(node.right);
	                    dist.offer(dist_+1);
	                }
	                if(map.get(node) != null) {
	                    queue.offer(map.get(node));
	                    dist.offer(dist_+1);
	                }
	            }
	            visited.add(node);
	            
	            
	        }
	        return list;
	    }
	    public void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map, TreeNode parent) {
	        if(root == null)
	            return;
	        map.put(root, parent);
	        dfs(root.left, map, root);
	        dfs(root.right, map, root);
	    }
	}

