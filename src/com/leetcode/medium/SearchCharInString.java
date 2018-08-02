package com.leetcode.medium;

public class SearchCharInString {
	public static void main(String[] args) {
		String inp = "pasdarasdaoasdagasdasrasdaaamadsamasdaiasdadnasdasdasdadas";
		
		String target = "programming";
		System.out.println(search(inp, target));
		String temp = new StringBuilder().append(inp).append(inp).reverse().toString();
		
		System.out.println(search(temp, new StringBuilder(target).reverse().toString()));

	}

	private static int search(String inp, String target) {
		int start = 0;
		boolean found = false;
		int count = 0;
		int j = 0;
		int end = -1;
		boolean last = false;
		for(int i=0;i<inp.length() && !last;i++) {
			if(inp.charAt(i) == target.charAt(j)) {
				if(j == target.length() - 1) {
					end = i;
					last = true;
				}
				j++;
			}
		}
		return end;		
	}
}

