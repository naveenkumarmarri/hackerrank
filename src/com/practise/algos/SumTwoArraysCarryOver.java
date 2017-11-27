package com.practise.algos;

public class SumTwoArraysCarryOver {

	public static void main(String[] args) {
		
		int [] a = {1,2,3};
		int [] b = {2,3,5,5};
		int a_length = a.length;
		int b_length = b.length;
		int merged = (a_length>b_length)?a_length:b_length;
		int [] m = new int[merged];
		for(int i=merged-1;i>=0;i--)
		{
			if(i<=a_length)
			m[i] = b[i]+a[i];
		}

	}

}
