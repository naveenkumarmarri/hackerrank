package com.practise.fun;

public class NumLongestIncSubSeq {

	public static void main(String[] args) {
		int []  a = {1,3,5,4,7};
		int [] dp = new int[a.length];
		for(int i=0;i<dp.length;i++)
			dp[i] = 1;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i;j>=0;j--)
			{
				
				if(a[j]<a[i])
				{
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
					
			}
		}
		int count=0;
		int lis = dp[a.length-1];
		for(int i=0;i<a.length;i++)
		{
			if(dp[i]==dp[i-1])
				count++;
		}
		System.out.println(count);
		
		
	}

}
