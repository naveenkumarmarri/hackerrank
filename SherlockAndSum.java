
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SherlockAndSum {
	
	 static int countWaysUtil(int n)
	    {
	        if (n <= 2)
	            return n;
	        if (n == 3)
	            return 4;
	        else
	        	return countWaysUtil(n-1)+countWaysUtil(n-2)+countWaysUtil(n-3);
	        
	    }
	  
	    // Returns number of ways to reach s'th stair
	    static int countWays(int s, int m)
	    {
	        return countWaysUtil(s);
	    }
	 
	 
	    /* Driver program to test above function */
	    public static void main (String args[])
	    {
	          int s = 7,m = 3;
	          System.out.println("Number of ways = "+ countWays(s,m));
	    }
		
	}

