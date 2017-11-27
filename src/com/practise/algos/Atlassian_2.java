package com.practise.algos;

import java.math.BigInteger;

public class Atlassian_2 {

	public static void main(String[] args) {


int n = 6;
		int q =1;
		int [] orig = {1,2,4,6};
		int [] dest = {3,3,3,4};


		int [] p =compatible(n,q,orig,dest);
		for(int i:p)
			System.out.println(i);
		//System.out.println(computeGCD(4, 3));
	}

	private static int[] compatible(int n, int q, int[] orig, int[] dest) {
		int [] res = new int[orig.length];
		
		for(int i=0;i<orig.length;i++)
		{
			for(int j=0;j<orig.length;j++)
			{
				if(i!=j)
				{
					int temp = computeGCD(orig[i],dest[j]);
					System.out.println(orig[i]+"--"+dest[j]+"--"+temp);
					if(temp>q)
						res[i]=1;
					
				}
				
			}
			
		}
		
		return res;
	}

	private static int computeGCD(int x, int y) {
		 BigInteger b1 = new BigInteger(""+x); 
		    BigInteger b2 = new BigInteger(""+y);
		    BigInteger gcd = b1.gcd(b2);
		    return gcd.intValue();
	}
	

}
