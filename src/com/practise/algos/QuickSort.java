package com.practise.algos;

public class QuickSort {

	public static void main(String[] args) {
			
		int [] a = {3,6,2,1,9,7};
		for(int i =0;i<a.length;i++)
		{
			int p = partition(a,0,a.length-1);
			partition(a,0, p);
			partition(a,p+1,a.length-1);
		}

	}

	private static int partition(int[] a, int i, int j) {
		
		return 0;
	}

}
