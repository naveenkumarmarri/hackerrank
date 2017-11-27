import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Implement a simplified version of Huffman encoding on a string with
 * a given distribution for each character in it.  The chars are the
 * vowels of the latin alphabet.
 * @author thiebaut
 *
 */
public class Test {
      public static void main(String[] args) {
    	  System.out.println("Nuber of ways = " + countWays(3, 3));
	}
      
      static int countWaysUtil(int n, int m)
  	{
  	    int res[] = new int[n];
  	    res[0] = 1; res[1] = 1;
  	    for (int i=2; i<n; i++)
  	    {
  	       res[i] = 0;
  	       for (int j=1; j<=m && j<=i; j++)
  	         res[i] += res[i-j];
  	    }
  	    return res[n-1];
  	}
  	 
  	// Returns number of ways to reach s'th stair
  	static int countWays(int s, int m)
  	{
  	    return countWaysUtil(s+1, m);
  	}
      // Returns number of ways to reach s'th stair
     
}