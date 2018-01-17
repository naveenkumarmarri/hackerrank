package com.leetcode.medium;

public class LongestPalindromeSeq {

	public static void main(String[] args) {
		String inp = "CBBD";
		char [] ip = inp.toCharArray();
		int [][] tab = new int[ip.length][ip.length];
		if(ip[0] == ip[ip.length-1])
		{
			for(int i=0;i<tab.length;i++) {
				tab[0][i]=1;
			}
		}
		else
		{
			for(int i=0;i<tab.length;i++) {
				tab[0][i]=0;
			}
			
		}
		for(int i=1;i<tab.length;i++)
			tab[i][0]=0;
		for(int i=1;i<tab.length;i++)
		{
			for(int j=1;j<tab.length;j++)
			{
				if(ip[i-1] == ip[tab.length-i-1])
				{
					tab[i][j] = Math.max(tab[i-1][j]+1, tab[i][j-1]); 
				}
				else
					tab[i][j]=Math.max(tab[i-1][j], tab[i][j-1]);
			}
		}
		System.out.println(tab[tab.length-1][tab.length-1]);

	}

}
