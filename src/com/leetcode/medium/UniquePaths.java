package com.leetcode.medium;

public class UniquePaths {
	
	    public int uniquePaths(int m, int n) {
	        int [][] locs = new int[n][m];
	        for(int i=0;i<m;i++)
	            locs[0][i] = 1;
	        for(int i=0;i<n;i++)
	            locs[i][0] = 1;
	        for(int i=1;i<n;i++) {
	            for(int j=1;j<m;j++) {
	                locs[i][j] = locs[i-1][j]+ locs[i][j-1];
	            }
	        }
	        return locs[n-1][m-1];
	    }
	}
