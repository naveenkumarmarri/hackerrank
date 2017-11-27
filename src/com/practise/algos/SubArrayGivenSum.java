package com.practise.algos;

import java.util.Arrays;

public class SubArrayGivenSum {

	public static void main(String[] args) {
		int [] inp = {1,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10};
		Arrays.sort(inp);
		System.out.println(min(inp,0,inp.length-1,-15));
		System.out.println(isSubsetSum(inp, 19));
		
	}

	private static boolean min(int[] inp, int i, int j,int target) {
			
			int sum = 0;
			for(int k=i;k<=j;k++)
				sum+=inp[k];
			if(sum==target)
				return true;
			if(i<j)
				return min(inp,i,j-1,target) ||
						min(inp,i+1,j,target);
		return false;
	}
	
	 static boolean isSubsetSum(int input[],  int total)
	    {
	        boolean T[][] = new boolean[input.length + 1][total + 1];
	        for (int i = 0; i <= input.length; i++) {
	            T[i][0] = true;
	        }

	        for (int i = 1; i <= input.length; i++) {
	            for (int j = 1; j <= total; j++) {
	                if (j - input[i - 1] >= 0) {
	                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
	                } else {
	                    T[i][j] = T[i-1][j];
	                }
	            }
	        }
	        return T[input.length][total];

	    }

}
