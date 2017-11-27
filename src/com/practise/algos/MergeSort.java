package com.practise.algos;

 class MergeSort {

	public static void main(String[] args) {

		int [] A = {-1,0,22,11,8,2,-8,21,22};
		MergeSort merge = new MergeSort();
		merge.mergeSort(A,0,A.length-1);
		for(int i:A)
			System.out.println(i);
	}
	

	 int partition(int arr[], int low, int high)
	    {
	        int pivot = arr[high]; 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<high; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (arr[j] <= pivot)
	            {
	                i++;
	 
	                // swap arr[i] and arr[j]
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	 
	        return i+1;
	    }
	 
	 
	    /* The main function that implements QuickSort()
	      arr[] --> Array to be sorted,
	      low  --> Starting index,
	      high  --> Ending index */
	    void sort(int arr[], int low, int high)
	    {
	        if (low < high)
	        {
	            /* pi is partitioning index, arr[pi] is 
	              now at right place */
	            int pi = partition(arr, low, high);
	 
	            // Recursively sort elements before
	            // partition and after partition
	            sort(arr, low, pi-1);
	            sort(arr, pi+1, high);
	        }
	    }



	    private static void mergeSort(int[] arr, int p, int r)
		{
			if(p < r)
			{
				int q = (p+r)/2;
				mergeSort(arr, p, q);
				mergeSort(arr, q+1, r);
				merge(arr, p, q, r);
				
			}
		}
		
		
		/**
		 * Merge function
		 * @param arr, original array
		 * @param p, start index of first array
		 * @param q, end index of first array
		 * @param r, end index of array arr
		 */
		public static void merge(int[] arr, int p, int q, int r)
		{
			final int n1 = q - p + 1;
			final int n2 = r - q;
			final int[]left = new int[n1+1];
			final int[]right = new int[n2+1];
			for(int i = 0; i < n1; i++)
			{
				left[i] = arr[p+i];
			}
			
			for(int i = 0; i < n2; i++)
			{
				right[i] = arr[q+i+1];
			}
			
			left[n1]  = Integer.MAX_VALUE;
			right[n2] = Integer.MAX_VALUE;
			int i = 0, j = 0;
			for(int k = p; k <= r;k++)
			{
				if(left[i] <= right[j])
				{
					arr[k] = left[i++];
				}
				else
				{
					arr[k] = right[j++];
				}
			}
		}

}
