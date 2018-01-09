package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubTreeSum {
	

 	 
	
	    public static ArrayList<Integer> sum = new ArrayList<Integer>();
	    public int[] findFrequentTreeSum(TreeNode root) {
	    
	            freq(root);    
	            return findMax(sum);
	        
	    }
	    public static int[] findMax(ArrayList<Integer> sum)
	    {
	        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
	        for(int i:sum)
	        {
	            if(counter.get(i)!=null)
	                counter.put(i, counter.get(i)+1);
	            else
	                counter.put(i, 1);
	        }
	        int max = Integer.MIN_VALUE;
	        //counter.forEach((k ,v) -> {if(v>max){max = v;}});
	        for(Map.Entry<Integer,Integer> m : counter.entrySet())
	        {
	            if(m.getValue() > max)
	                max = m.getValue();
	        }
	        ArrayList<Integer> ret = new ArrayList<Integer>();
	        //counter.forEach((k, v) -> {if(v == max){ret.add(v);}});
	        for(Map.Entry<Integer, Integer> m : counter.entrySet())
	        {
	            if(m.getValue() == max)
	                ret.add(m.getKey());
	        }
	        return ret.stream().mapToInt(i -> i).toArray();
	    }
	    public static int freq(TreeNode root)
	    {
	        if(root==null)
	            return 0;
	        else if(root.left == null && root.right!=null)
	        {
	            
	            int temp = (root.val+freq(root.right));
	            sum.add(temp);
	            return temp;
	        }
	        else if(root.left!=null && root.right == null)
	        {
	            int temp = (root.val+freq(root.left));
	            sum.add(temp);
	            return temp;
	        }   
	        else if(root.left!=null && root.left!=null)
	        {
	            int temp = (root.val+(freq(root.left)+freq(root.right)));
	            sum.add(temp);
	            return temp;
	        }
	        else if(root.left == null && root.right == null)
	        {
	            sum.add(root.val);
	            return root.val;
	            
	        }
	        else
	        return 0;
	        
	    }
	    
	
}
	 class TreeNode {
	 		int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

