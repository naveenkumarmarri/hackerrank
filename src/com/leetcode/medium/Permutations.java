package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;



public class Permutations {
	public static void main(String[] args) {
		List<List<Integer>> list = permute(new int[]{1,2,3, 3});
		for(List<Integer> l: list) {
			for(int i: l) {
				System.out.print(i+" ");
			}
			System.out.println("\n");
		}
	}

	private static List<List<Integer>> permute(int[] is) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(is.length == 0)
			return list;
		return permuteAll(is, 0, list);
		
	}

	private static List<List<Integer>> permuteAll(int[] is, int start, List<List<Integer>> list) {
		if(start == is.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i:is) 
				temp.add(i);
			list.add(temp);
		}
		for(int i=start; i<is.length;i++) {
			swap(is, i, start);
			permuteAll(is, start+1, list);
			swap(is, i, start);
		}
		return list;
	}

	private static void swap(int[] is, int i, int start) {
		int temp = is[i];
		is[i] = is[start];
		is[start] = temp;
	}
	
}
