package com.practise.algos;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Atlassian_1 {

	public static void main(String[] args) {
		int [] ele = {1,2,3};
		int [] ret = rearrange(ele);
		for(int i:ret)
			System.out.println(i);
		
	}
	static int countOnes(String s)
	{
		char[] inp = s.toCharArray();
		int count=0;
		for(char c:inp)
		{
			if(c=='1')
				count++;
		}
		return count;
	}
	static int [] rearrange(int [] ele)
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i:ele)
		{
			String s = Integer.toBinaryString(i);
			map.put(i, countOnes(s));
		}
		Atlassian_1 t = new Atlassian_1();
		ValueComparator bvc = t.new ValueComparator(map);
        TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(bvc);
        sorted_map.putAll(map);
        Set<Integer> set = sorted_map.keySet();
        
        int [] ret = new int[sorted_map.keySet().size()];
        Iterator<Integer> it = set.iterator();
        for(int i=0;i<ret.length&&it.hasNext();i++)
        {
        	ret[i] = it.next();
        }
		return ret;
	}
	class ValueComparator implements Comparator<Integer> {
	    Map<Integer, Integer> base;

	    public ValueComparator(Map<Integer, Integer> base) {
	        this.base = base;
	    }

	    public int compare(Integer a, Integer b) {
	    	if (base.get(a) > base.get(b)) {
	            return 1;
	        } else if(base.get(a)==base.get(b)){
	        	
	            if(a>=b)
	            	return 1;
	            else
	            	return -1;
	        } 
	        else
	        	return -1;// returning 0 would merge keys
	    }
	}
}

