package com.leetcode.medium;

public class LongestIncreasingPath {
	    public int longestIncreasingPath(int[][] matrix) {
	        int max = 0;
	        if(matrix.length == 0)
	            return max;
	        int[][] dp = new int[matrix.length][matrix[0].length];
	        for(int i=0;i<matrix.length;i++) {
	            for(int j=0;j<matrix[0].length;j++) {

	                max = Math.max(max, dfs(matrix, i, j, dp));
	            }
	        }
	        return max;
	    }
	    public int dfs(int[][] matrix, int i, int j, int[][] dp) {
	        if(i < 0 || i > matrix.length-1 || j < 0 || j > matrix[0].length-1)
	            return 0;
	        if(dp[i][j] != 0)
	            return dp[i][j];
	        if(i > 0 && matrix[i][j] < matrix[i-1][j])
	            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i-1, j, dp));
	        if(j > 0 && matrix[i][j] < matrix[i][j-1])
	            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j-1, dp));
	        if(i < matrix.length-1  && matrix[i][j] < matrix[i+1][j])
	            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i+1, j, dp));
	        if(j < matrix[0].length-1  && matrix[i][j] < matrix[i][j+1])
	            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j+1, dp));

	        return ++dp[i][j];
	    }
	
}
