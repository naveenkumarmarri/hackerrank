package com.practise.algos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GS_2 {

	public static void main(String[] args) {
		String [][] scores = {{"Elaine","-99.99"}};
		HashMap<String,Double> sum_map = new HashMap<String,Double>();
		HashMap<String,Integer> count_map = new HashMap<String,Integer>();
		
		for(String[] score:scores)
			{
				if(sum_map.containsKey(score[0]))
				{
					count_map.put(score[0], count_map.get(score[0])+1);
					double temp = sum_map.get(score[0])+Double.parseDouble(score[1]);
					sum_map.put(score[0], Math.floor(temp));	
				}
				else
				{
					sum_map.put(score[0], Double.parseDouble(score[1]));
					count_map.put(score[0], 1);
				}
			}
		
		for(Map.Entry<String, Integer> pai:count_map.entrySet())
		{
			
			double sum = sum_map.get(pai.getKey());
			int count = count_map.get(pai.getKey());
			sum_map.put(pai.getKey(),Math.floor(sum/count));
		}
		Map.Entry<String, Double> max = null;
		for(Map.Entry<String, Double> t:sum_map.entrySet())
		{
			if(max==null||t.getValue().compareTo(max.getValue())>0)
				max=t;
		}
		
		System.out.println(Math.round(Math.floor(max.getValue())));

	}
	public static class ValueLess extends Exception{
	    public ValueLess(String message)
	    {
	        super("less than zer");
	    }
	}

}
