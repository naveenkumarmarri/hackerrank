package com.practise.algos;

import java.util.*;

public class LargestSumContigious {
	/*package whatever //do not write package name here */


	
		public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			for(int i=0;i< n; i++) {
			    int m = sc.nextInt();
			    int [] arr = new int[m];
			    for(int j=0;j<m;j++) {
			        arr[j] = sc.nextInt();
			    }
			    
			    int max_so_far = arr[0];
			    int max_ending_here = arr[0];
			    for(int j=1;j<m;j++) {
			        max_ending_here = Math.max(max_ending_here + arr[j], arr[j]);
			        max_so_far = Math.max(max_ending_here, max_so_far);
			            
			    }
			    System.out.println(max_so_far);
			}
			sc.close();
		}
		
	}
