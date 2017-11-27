package com.practise.fun;

public class PosiNegSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums = {-1, 2, 4, -8, 10, 9, 100, -3, 2};
		for(int i : posiNegSort(nums))
			System.out.print(i + " ");
	}
	public static int[] posiNegSort(int [] nums){
		int p = 0; 
		int q = 0;
		while ( q < nums.length){
			while (nums[p] < 0)
				p++;
			q = p;
			while(q < nums.length && nums[q] > 0 )
				q++;
			if (q == nums.length)
				break;
			for(int i = q; i > p; i--){
				int t =nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = t;				
			}
		}
		return nums;
	}
}