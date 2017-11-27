package com.practise.fun;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InterleavedStrings {

	public static void main(String[] args) throws InterruptedException {
		String s3 = "WZXY";
		String s2 = "WZ";
		String s1 = "XY";
		char [] C = s3.toCharArray();
		char [] B = s2.toCharArray();
		char [] A = s1.toCharArray();
		int M = A.length;
		int N = B.length;
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int [] a = {3,4,5};
		Random r = new Random();
		Thread t = new Thread();
		t.join();
		t.sleep(r.nextInt(1000));
		if(M+N==C.length)
		{
			boolean [][] IL = new boolean[M][N];
			  for (int i=0; i<M; ++i)
			    {
			        for (int j=0; j<N; ++j)
			        {
			            // two empty strings have an empty string
			            // as interleaving
			            if (i==0 && j==0)
			                IL[i][j] = true;
			 
			            // A is empty
			            else if (i==0 && B[j-1]==C[j-1])
			                IL[i][j] = IL[i][j-1];
			 
			            // B is empty
			            else if (j==0 && A[i-1]==C[i-1])
			                IL[i][j] = IL[i-1][j];
			 
			            // Current character of C matches with current character of A,
			            // but doesn't match with current character of B
			            else if(A[i-1]==C[i+j-1] && B[j-1]!=C[i+j-1])
			                IL[i][j] = IL[i-1][j];
			 
			            // Current character of C matches with current character of B,
			            // but doesn't match with current character of A
			            else if (A[i-1]!=C[i+j-1] && B[j-1]==C[i+j-1])
			                IL[i][j] = IL[i][j-1];
			 
			            // Current character of C matches with that of both A and B
			            else if (A[i-1]==C[i+j-1] && B[j-1]==C[i+j-1])
			                IL[i][j]=(IL[i-1][j] || IL[i][j-1]) ;
			        }
			    }
			  System.out.println(IL[M][N]);
		}
		else
			System.out.println(false);
		
		  
		
	}

}
