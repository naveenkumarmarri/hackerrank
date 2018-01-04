package com.practise.fun;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		 int [] a = {3,2,3};
		 Arrays.sort(a);
		 int [] b = new int[3];
		 b = Arrays.copyOfRange(a, 0, a.length);
		 //System.out.println(binarySearch(4, a, 0, 3));
		 for(int i:b)
			 System.out.println(i);
	}
	public static int binarySearch(int x, int[] nums, int start, int end)
	{
		if(start<=end)
		{
			int mid = (start + end) /2;
			
			if(nums[mid]==x)
				return mid;
			if(nums[mid]>x)
				return binarySearch(x, nums, start, mid-1);
			if(nums[mid]<x && !(mid<end))
			return binarySearch(x, nums, mid+1, end);
		}
		return -1;
	}

}
