package com.leetcode.medium;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int [] height = new int[] {4,6,2,1,3};
		int max_height = Integer.MIN_VALUE;
		for(int i=0;i<height.length;i++) {
			int loc_height = 0;
			for(int j=i+1;j<height.length;j++) {
				if(height[i] >= height[j] ) {
					loc_height+=height[j];
				}
			}
			if(max_height<loc_height)
				max_height = loc_height;
		}
		System.out.println(max_height);
	}
}
