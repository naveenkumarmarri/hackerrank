package com.practise.algos;

public class CoinChange {

	public static void main(String[] args) {
		int [] elements = {1 ,2,3};
		int sum=4;
		int [] array = new int[sum+1];
		for(int i=1;i<array.length;i++)
			array[i] = Integer.MAX_VALUE;
	
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<elements.length;j++)
			{
				if(elements[j]<=i && array[i-elements[j]]!=Integer.MAX_VALUE)
				{
					array[i] = Math.min(array[i-elements[j]],array[i])+1;
				}
				
			}
		}
		
		int i = sum;
		while(array[i]>0)
		{
			boolean flag = false;
			for(int j=0;j<elements.length;j++)
			{
				if(array[i]-1 == array[i-elements[j]] && flag!=true)
				{
					flag=true;
					System.out.println(elements[j]);
					i=i-elements[j];
				}
			}
			
		}
		

	}

}
