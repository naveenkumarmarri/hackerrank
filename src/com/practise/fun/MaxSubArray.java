package com.practise.fun;

public class MaxSubArray {

	public static void main(String[] args) {
		int [] a =  {1, 2, -4, 1, 3, -1, 2, 3};
	//	System.out.println(Math.floor(11.5));
		System.out.println(maxSum(a, 0, a.length-1));

	}
	public static int maxSum(int [] inp,int left,int right)
	{
		if(left == right)
			return inp[left];
		
		return Math.max(Math.max(maxSum(inp,left,(int)Math.floor((left+right)/2)), 
						maxSum(inp,(int)Math.floor((left+right))/2+1,right)), 
						maxValue(inp,left,(int)Math.round(Math.floor((left+right)/2)),right));
		
		
		//else
			//return 0;
	}
	private static int maxValue(int[] inp, int left, int mid, int right) 
	{
		int minLeft = inp[left];
		int curSum = 0;
		for(int i=mid;i>=left;i--)
		{
			curSum += inp[i];
			if(curSum>minLeft)
				minLeft=curSum;
		}
		
		int minRight = inp[right];
		curSum = 0;
		for(int i= mid+1;i<=right;i++)
		{
			curSum += inp[i];
			if(curSum>minRight)
				minRight = curSum;
		}
		
		return minLeft+minRight;
	}

}
