package com.practise.algos;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int x = 0;x<n;x++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String l = sc.next();
			String m = sc.next();
			char [] a_ = l.toCharArray();
			char [] b_ = m.toCharArray();
			int [][] edit = new int[a_.length+1][b_.length+1];
			for(int i=0;i<=a_.length;i++)
			    edit[i][0] = i;
			for(int j=0;j<=b_.length;j++)
			    edit[0][j] = j;
			    
			for(int i=1;i<=a;i++) {
				for(int j=1;j<=b;j++) {
					if(a_[i-1] != b_[j-1])
						edit[i][j]=1+Math.min(edit[i-1][j-1], Math.min(edit[i-1][j], edit[i][j-1]));
					else
						edit[i][j]=(edit[i-1][j-1]);
				}
			}
			System.out.println(edit[a_.length][b_.length]);
		}
		sc.close();
	}
}
