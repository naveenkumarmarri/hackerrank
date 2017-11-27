package com.practise.algos;

public class BinSearch {

	public static void main(String[] args) {
		int [] inp = {2,5,6,7,11,22,44};
		int target = -1;
		int found = binSearch(inp,0,inp.length-1,target);
		if(found!=-1)
			System.out.println(found+1);
		else
			System.out.println("Not found");

	}

	private static int binSearch(int[] inp, int i, int j, int target) {
		int mid = Math.floorMod(i, j);
		if(i>j)
			return -1;
		if(inp[mid]==target)
			return mid;
		else
		{
			if(inp[mid]<target)
				return binSearch(inp, mid+1, j, target);
			if(inp[mid]>target)
				return binSearch(inp, i, mid-1, target);
		}
		
		return -1;
	}

}
