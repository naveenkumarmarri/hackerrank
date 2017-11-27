package com.practise.algos;

public class FreqEleInArray {

	public static void main(String[] args) {
		int [] a = {2,3,3,5,3,4,1,7};
		for(int i=0;i<a.length;i++)
			a[a[i]%a.length]= a[a[i]%a.length]+a.length;
		
		int max = a[0];
		int max_loc = 0;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
				max_loc=i;
			}
				
		}
			System.out.println(max_loc);
	}

}

