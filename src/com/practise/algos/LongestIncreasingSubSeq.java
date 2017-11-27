package com.practise.algos;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		int [] elements = {1,3,5,4,7};
		int [] sequence = new int[elements.length];
		for(int i=0;i<sequence.length;i++)
			sequence[i]=1;
		
		for(int i=0;i<elements.length;i++)
		{
			int max_found = sequence[i];
			boolean flag=false;
			boolean elements_found = false;
			for(int j=0;j<i;j++)
			{
				if(elements[j]<elements[i] )
				{
					elements_found=true;
					if(sequence[j]>max_found)
					{
						flag=true;
						max_found=sequence[j];
					}		
				}
			}
			if(elements_found || flag)
				sequence[i]=max_found+1;
			else
				sequence[i]=max_found;
		}
		//System.out.println(sequence[sequence.length-1]);
		int max =0;
		for(int i:sequence)
		{
			System.out.println(i);
		}
		int count=0;
		for(int i:sequence)
		{
			if(i==max)
				count++;
		}

				
	}

}
