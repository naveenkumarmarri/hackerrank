package com.practise.algos;

public class BinarySearch {

	public static void main(String[] args) {
			int [] a = {1,3,4,6,7,9,11};
			System.out.println(binarySearch(a, 0, a.length,11));

	}

	private static int binarySearch(int[] a,int left, int right, int i) {
		
		if(left <= right) {
			int mid = Math.floorDiv((left+right), 2);
			if(a[mid] == i)
				return mid;
			else if(i > a[mid])
				return binarySearch(a, mid+1, right, i);
			
			else
				return binarySearch(a, left, mid-1, i);
		}
		
		return -1;
		
	}

}
