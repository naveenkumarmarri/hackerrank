package com.practise.fun;

import java.util.Scanner;

public class SumToNumPartition {

	public static void main(String[] args) {
		int x=1;
		int y=3;
		int z=4;
		Scanner sc = new Scanner(System.in);
		int target = 5;
		for(int i=0;i<=target;i++)
		{
			for(int j=0;j<=target;j++)
			{
				for(int k=0;k<=target;k++)
				{
					if(x*i+y*j+z*k==target)
						System.out.println(i+" "+j+" "+k);
				}
			}
		}
	}

}
