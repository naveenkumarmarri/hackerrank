package com.practise.fun;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Test {
	public static void main(String[] args) throws ParseException {
		Test t = new Test();
		System.out.println(t.solution(1, 2, 3, 4, 5, 6));
	}
 public String solution(int A, int B, int C, int D, int E, int F) throws ParseException {
      Pattern pattern;
		  Matcher findMatcher;
		  
		 ArrayList<Integer> al = new ArrayList<>();
		 al.add(A);
		 al.add(B);
		 al.add(C);
		 al.add(D);
		 al.add(E);
		 al.add(F);
	
		 String min = permute(al,al.size());
		 if(min.equals("23:59:59"))
		    return "NOT POSSIBLE";
		   else
		   return min;
		  
		  
 }
	 static String permute(java.util.List<Integer> arr, int k) throws ParseException{
		 String min="23:59:59";   
		 for(int i = k; i < arr.size(); i++){
	            java.util.Collections.swap(arr, i, k);
	            if(isMin(permute(arr, k+1),min))
	            		{
	            			min=permute(arr, k+1);
	            		}
	            java.util.Collections.swap(arr, k, i);
	        }
	        if (k == arr.size() -1){
	           char[] temp = java.util.Arrays.toString(arr.toArray()).toCharArray();
	           //System.out.println(temp[1]);
	           
	           char hh_1=temp[1];
	            char hh_2=temp[4];
	            char mm_1=temp[7];
	            char mm_2=temp[10];
	            char ss_1=temp[13];
	            char ss_2=temp[16];
	            String time =hh_1+""+hh_2+":"+mm_1+""+mm_2+":"+ss_1+ss_2;
	            Pattern pattern;
	  		  Matcher findMatcher;
	  		  
	  		  
	  		  String regExp =
	  	                 "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
	  		  pattern = Pattern.compile(regExp);
	  		  findMatcher = pattern.matcher(time);
	  		  if(findMatcher.matches())
	  		  {
	  		      if(isMin(time,min))
	  		      {
	  		          min=time;
	  		      }
	  		  }
	  		 
	        }
	        return min;
	        
	    }
	 public static boolean isMin(String cur,String min) throws ParseException
	    {
	        SimpleDateFormat d = new SimpleDateFormat(cur);
			  SimpleDateFormat d_1 = new SimpleDateFormat(min);	  
			  SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	          Date Date = format.parse(cur);
	          Date Date_1 = format.parse(min);
	          return (Date.before(Date_1));
	    }
 
}