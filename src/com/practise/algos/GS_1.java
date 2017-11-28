package com.practise.algos;

import java.util.StringTokenizer;

public class GS_1 {

	public static void main(String[] args) {
		String inp = "Hello World";
		StringTokenizer st = new StringTokenizer(inp);
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens())
		{
			
			sb.append(new StringBuilder(st.nextToken()).reverse().toString()+" ");
		}
		System.out.println(sb.toString().trim());
			

	}

}
