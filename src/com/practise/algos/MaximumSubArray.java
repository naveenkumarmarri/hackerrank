package com.practise.algos;

public class MaximumSubArray {

	public static void main(String[] args) {
		int [] a = {-2,1,-3,4,-1,2,1,-5,4};
		//int [] a = {-2,-1};
		//int []  a = {1,2};
		int max = a[0];
		int max_ending_here = a[0];
		for(int i=1;i<a.length;i++)
		{
			
				max_ending_here = Math.max(a[i],max_ending_here+a[i]);
				max = Math.max(max_ending_here, max);
			
		}
		System.out.println(max);

	}

}
