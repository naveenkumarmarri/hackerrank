package com.practise.algos;


public class MergeSortCountInversions {

	public static void main(String[] args) {
		int [] a = {1,1,1,2,2};
		mergeSort(a, 0, a.length-1);
		for(int i:a)
			System.out.println(i);

	}
	public static void mergeSort(int [] a,int i,int j)
	{
		if(i<j)
		{
			int mid = (i+j)/2;
			mergeSort(a,i,mid);
			mergeSort(a,mid+1,j);
			merge(a,i,mid,j);
		}
	}
	public static void merge(int []a,int i,int mid,int j)
	{
		int count=0;
		int left = mid-i+1;
		int right = j-mid;
		int [] l = new int[left];
		int [] r = new int[right];
		
		for(int x=0;x<l.length;x++)
			l[x] = a[x+i];
		for(int y=0;y<r.length;y++)
			r[y] = a[mid+y+1];
		int x=0,y=0;
		
		while(x<left&&y<right)
		{
			if(l[x]<= r[y])
			{
				a[i++]=l[x++];
				count++;
			}			
			else
				a[i++]=r[y++];
			
			//i++;
		}
		while(x<left)
		{
			a[i++]=l[x++];
		}
		while(y<right)
			a[i++]=r[y++];
		System.out.println(count);
	}


}
