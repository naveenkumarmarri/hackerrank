package com.practise.fun;

import java.util.ArrayList;
import java.util.HashMap;

public class LR_1 {

	public static void main(String[] args) {
		
		int [] A = new int [] {7,3,7,3,1,3,4,1};
		System.out.println(solution(A));
	}

	private static int solution(int[] a) {
		ArrayList<Integer> distinctPlaces = new ArrayList<Integer>();
		HashMap<Integer,Integer> counter = new HashMap<Integer, Integer>();
		for(int i:a)
		{
			if(!distinctPlaces.contains(i))
			{
				distinctPlaces.add(i);
				
			}
				
		}
		ArrayList<Integer> visitedDistinctPlaces = new ArrayList<Integer>();
		int tracker = 0;
		int temp=0;
		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE;
		
		for(int place=0;place<a.length ;place++)
		{
			if(!counter.containsKey(a[place]) && distinctPlaces.contains(a[place]))
			{
				tracker++;
				counter.put(a[place], 0);
			}
			counter.put(a[place], counter.get(a[place])+1);
			if(tracker == distinctPlaces.size())
			{
				while((counter.get(a[temp])>1) || !(distinctPlaces.contains(a[temp])))
				{
					counter.put(a[temp], counter.get(a[temp])-1);
					temp++;
				}
			}
			
			if(place - temp < min)
			{
				start = place;
				end = temp;
			}
		}
		
		
		return  end - start;
	}

	private static int solution_1(int[] a) {
		int count=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<=i+1)
			{
				count++;
			}
		}
		return count;
		
	}

}
