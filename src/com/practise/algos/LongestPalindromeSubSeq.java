package com.practise.algos;

/*
 * Approach used is similar to longest common subsequence but after reversing the string
 */
public class LongestPalindromeSubSeq {

	public static void main(String[] args) {
		String inp = "agbdba";
		char [] a= inp.toCharArray();
		char []b = new StringBuilder(inp).reverse().toString().toCharArray();
		int [][] lps = new int[a.length+1][a.length+1];
		
		for(int i=1;i<=a.length;i++) {
			for(int j=1;j<=a.length;j++) {
				if(a[i-1] == b[j-1])
					lps[i][j] = lps[i-1][j-1] + 1;
				else 
					lps[i][j] = Math.max(lps[i-1][j], lps[i][j-1]);
			}
		}
		System.out.println(lps[a.length][a.length]);

	}

}
