package com.ctci;

public class Primality {

	public static void main(String[] args) {
		if(!checkPrime(12))
			System.out.println("prime");
		else
			System.out.println("not prime");

	}

	private static boolean checkPrime(int value) {
		//int [] prime = new int[value];
		for(int i=2;i<Math.sqrt(value);i++)
		{
			if(value%i==0)
				return true;
		}
		return false;
		
		
	}

}
