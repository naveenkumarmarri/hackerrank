package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestWordDictionary {

	    public String findLongestWord(String s, List<String> d) {
	        char [] char_s = s.toCharArray();
	        ArrayList<String> match = new ArrayList<String>();
	        ArrayList<String> longest = new ArrayList<String>();
	        for(String dict:d)
	        {
	            char [] char_dict = dict.toCharArray();
	            int pos = 0;
	            int count = 0;
	            for(int i=0;i<char_dict.length;i++)
	            {
	                pos = find(char_dict, char_s, i, pos);
	                if(pos!=-1)
	                {
	                    count++;
	                    pos++;
	                }
	                    
	                else
	                    break;
	            }
	            if(count==dict.length())
	                match.add(dict);
	        }
	        int max = 0;
	        for(String x:match)
	        {
	            if(x.length()>max)
	                max = x.length();
	        }
	        for(String x:match)
	        {
	            if(x.length()==max)
	                longest.add(x);
	        }
	        if(longest.size()==1)
	            return longest.get(0);
	        
	        else if(longest.size()>1)
	        {
	            String [] l = new String[longest.size()];
	            longest.toArray(l);
	            String small = l[0];
	            for(int i = 1;i<l.length;i++)
	            {
	                if(l[i].compareTo(small) < 0)
	                {
	                    small = l[i];
	                }
	            }
	            return small;
	        }
	        else
	        return "";
	        
	        
	    }
	    private static int find(char[] char_dict, char[] char_s,int dict_pos, int s_pos) {
			for(int j=s_pos;j<char_s.length;j++)
			{
				if(char_s[j]==char_dict[dict_pos])
					return j;
			}
			return -1;
			
		}
	}


