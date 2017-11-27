package com.practise.algos;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SubsetToSize {

	public static void main(String[] args) {
		
		int [] a = {1,2,3,4,5,6,7};
		HashMap<Integer,Integer> seenSoFar = new HashMap<Integer,Integer>();
		int target = 3;
		HashMap<Integer,Integer> seen = elelmentsWithSize(a,0,a.length-1,seenSoFar,target);
		Iterator it = seen.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>)it.next();
			for(int i=pair.getKey();i<=pair.getValue();i++)
			{
				System.out.println(a[i]);
			}
			System.out.println("--------");
		}
	}

	private static HashMap<Integer,Integer> elelmentsWithSize(int[] a, int i, int j, HashMap<Integer, Integer> seenSoFar,int target) {
		if(Math.abs(j-i+1)==target)
			seenSoFar.put(i, j);
			
		if(i<j)
		{
			Iterator it = (seenSoFar.entrySet().iterator());
			boolean seen = false;
			boolean seen_second = false;
			while(it.hasNext())
			{
				Map.Entry<Integer,Integer> pair = (Map.Entry)it.next();
				if((pair.getKey() == i+1 && pair.getValue() == j)||(pair.getKey() == j && pair.getValue() == i+1))
				{
					seen = true;
				}
				if((pair.getKey() == i && pair.getValue() == j-1)||(pair.getKey() == j-1 && pair.getValue() == i))
				{
					seen_second = true;
				}
					
			}
			System.out.println(seenSoFar);
			if(!seen)
				return elelmentsWithSize(a, i+1, j, seenSoFar,target);
			if(!seen_second)
				return elelmentsWithSize(a, i, j-1, seenSoFar,target);
		}
		return seenSoFar;
		
	}

}
