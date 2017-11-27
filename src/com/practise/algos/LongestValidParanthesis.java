package com.practise.algos;

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args) {
		String inp = "()(()";
		char [] values = inp.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int [] tracker = new int[values.length];
		for(int i=0;i<tracker.length;i++)
			tracker[i]=0;
		int longestLength = 0;
		int cur_length = 0;
		for(int i=0;i<values.length;i++)
		{
			if(values[i]==')')
			{
				if(!stack.isEmpty() && stack.peek()=='(')
				{
					cur_length+=2;
					stack.pop();
				}
				else
				{
					longestLength = Math.max(longestLength, cur_length);
					cur_length = 0;
				}
					
	
			}
			else if(values[i]=='(')
			{
				stack.push('(');
			}
				
		}
		longestLength = Math.max(longestLength, cur_length);
		
		System.out.println(longestLength);

	}

}
