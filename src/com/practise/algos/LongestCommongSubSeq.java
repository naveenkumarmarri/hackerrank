package com.practise.algos;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommongSubSeq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int k=0;k<n;k++) {
			String a = sc.next();
			String b = sc.next();
			char [] a_ = a.toCharArray();
			char [] b_ = b.toCharArray();
			int[][] lcq = new int[a.length()+1][b.length()+1];
			
			for(int i=1;i<=a.length();i++) {
				for(int j=1;j<=b.length();j++) {
					if(a_[i-1] == b_[j-1]) 
						lcq[i][j] = 1+lcq[i-1][j-1];
					else 
						lcq[i][j] = Math.max(lcq[i-1][j], lcq[i][j-1]);
					
				}
			}
			
			System.out.println(lcq[a_.length][b_.length]);
		}
		sc.close();
		
	}

}
