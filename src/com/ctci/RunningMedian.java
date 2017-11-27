package com.ctci;


import java.util.Scanner;

public class RunningMedian{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] inp=new int[n];
		for(int i=0;i<n;i++)
		{
			int ele = sc.nextInt();
			
			int [] min_heap = minHeapify(inp, 0, i);
			System.out.println("minheap---");
			for(int j:min_heap)
				System.out.println(j);
			int [] max_heap = maxHeapify(inp, 0, i);
			System.out.println("maxheap----");
			for(int j:max_heap)
				System.out.println(j);
			//System.out.println((min_heap[0]+max_heap[0])/2);
		}
		
	}

	private static int[] maxHeapify(int [] a,int start,int end) 
	{
		for(int l=0;l<end;l++)
		{
			int change = 0;
			for(int i=start;i<=end;i++)
			{
				if(2*i<=end)
				{
					if(a[i]<a[2*i])
					{
						int temp=a[i];
						a[i] = a[2*i];
						a[2*i] = temp;
						change=1;
					}
				}
				if((2*i)+1<=end)
				{
					if(a[i]<a[2*i+1])
					{

						int temp=a[i];
						a[i] = a[2*i+1];
						a[2*i+1] = temp;
						change=1;
					}
				}
			}
			if(change!=1)
			{
				return a;
			}
				
		}
		
		return a;
	}
	private static int[] minHeapify(int [] a,int start,int end) 
	{
		for(int l=0;l<end;l++)
		{
			int change = 0;
			for(int i=start;i<=end;i++)
			{
				if(2*i<=end)
				{
					if(a[i]>a[2*i])
					{
						int temp=a[i];
						a[i] = a[2*i];
						a[2*i] = temp;
						change=1;
					}
				}
				if((2*i)+1<=end)
				{
					if(a[i]>a[2*i+1])
					{

						int temp=a[i];
						a[i] = a[2*i+1];
						a[2*i+1] = temp;
						change=1;
					}
				}
			}
			if(change!=1)
			{
				return a;
			}
				
		}
		
		return a;
	}

}


