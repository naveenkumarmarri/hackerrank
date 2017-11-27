package com.practise.algos;

import java.math.BigInteger;

public class NumPartitions {

	public static void main(String[] args) 
	{
			
		System.out.println(getNumPartitions(50));
		System.out.println(getNumPartitions(100));
		System.out.println(getNumPartitions(200));
		System.out.println(getNumPartitions(1000));
		
		
		System.out.println(getNumPartitions(100000));
		System.out.println(getNumPartitions(200000));
		System.out.println(getNumPartitions(250000));
		System.out.println(getNumPartitions(210000));
		System.out.println(getNumPartitions(180000));
		
	}

	private static BigInteger getNumPartitions(int sum) {
		
		BigInteger i_1 = new BigInteger("1");
		BigInteger i_2 = new BigInteger("1");
		BigInteger i_3 = new BigInteger("2");
		BigInteger i_4 = new BigInteger("4");
		BigInteger x = new BigInteger("0");
		/*
		 * It is done using bottom up recursive fashion
		 * the recursion function looks like 
		 * getNumPartitions(n) = getNumPartitions(n-1)+getNumPartitions(n-3)+getNumPartitions(n-4);
		 * 
		 */
		for(int i=5;i<=sum;i++)
		{
			x = i_4.add(i_2).add(i_1);
			
			i_1 = i_2;
			i_2 = i_3;
			i_3 = i_4;
			i_4 = x;
		}
		
		return x.mod(new BigInteger("100000"));
	}

}
