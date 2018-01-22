package com.practise.algos;


public class QuickSort {

	public static void main(String[] args) {
			
		int [] a = {3,6,2,1,9,7};
		
		quickSort(a, 0, a.length-1);
		for(int i:a)
			System.out.println(i);

	}

	private static void quickSort(int[] a, int low, int high) {
		if(low < high) {
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot+1, high);
		}
		
	}

	private static int partition(int[] a, int low, int high) {
		
		int temp = low;
		int pivot = a[low];
		for(int i=low+1; i<= high; i++) {
			if(pivot < a[i]) {
				temp++;
				int x = a[temp];
				a[temp] = a[i];
				a[i] = x; 
				
			}
		}
		int y = a[temp-1];
		a[temp-1] = a[pivot];
		a[pivot] = y;
		
		return temp;
	}

}
