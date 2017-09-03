package com.practise.fun;

import java.util.Random;

public class RandomNumGen {

	public static void main(String[] args) {
		
		int[] seq = generateNonIncreasingSequence(50000);
		int[] incSeq = generateIncreasingSequence(50000);
		System.out.println(seq.length);
		System.out.println(incSeq.length);
	}
	private static int[] generateIncreasingSequence(int inp) 
	{
		int[] sequence = new int[inp];
		Random nonIncPattern = new Random();
		int min = 0;
		int max = 10;
		for(int i=0;i<inp;i++)
		{
			sequence[i] = nonIncPattern.nextInt((max-min))+min;
			min = max;
			max += 10;
		}
		return sequence;
	}
	
	private static int[] generateNonIncreasingSequence(int inp) 
	{
		int[] sequence = new int[inp];
		Random nonIncPattern = new Random();
		int min = inp*10-10;
		int max = inp*10;
		for(int i=0;i<inp;i++)
		{
			sequence[i] = nonIncPattern.nextInt((max-min))+min;
			max = min;
			min -= 10;
		}
		return sequence;
	}
}
