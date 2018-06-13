package com.leetcode.medium;

public class UniquePaths2 {
	    public int uniquePathsWithObstacles(int[][] obstacle) {
	        int n = obstacle[0].length;
	        int m = obstacle.length;
	        int[][] loc = new int[m][n];
	        for(int i=0; i<m; i++) {
	            if(obstacle[i][0] == 1)
	                break;
	            else
	                loc[i][0] = 1;    
	        }
	        for(int i=0;i<n;i++) {
	            if(obstacle[0][i] == 1)
	                break;
	            else
	                loc[0][i] = 1;
	        }
	        if(n == 0)
	            return loc[m-1][0];
	        else if(m == 0)
	            return loc[0][n-1];
	        for(int i=1;i<m;i++) {
	            for(int j=1;j<n;j++) {
	                if(obstacle[i][j] == 1)
	                    loc[i][j] = 0;
	                else if(obstacle[i-1][j] == 1 || obstacle[i][j-1] ==1 )
	                    loc[i][j] = Math.max(loc[i-1][j], loc[i][j-1]);
	                else
	                    loc[i][j] = loc[i-1][j]+loc[i][j-1];
	            }
	        }
	        return loc[m-1][n-1];
	        
	    }
	
}
