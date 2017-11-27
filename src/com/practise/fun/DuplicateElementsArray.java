package com.practise.fun;

public class DuplicateElementsArray {

	public static void main(String[] args) {
		int [] a = {1,3,4,1,3};
		System.out.println(fun(a,4));
		
	}
	public static int fun(int[]a,int right)
	{
		int val=0;
		if(right==0)
			return a[0];
		else {
			 val = fun(a,right-1);
			if(a[right]>val)
				val=a[right];
		}
			
		
		return val;
	}

}
