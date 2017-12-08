package com.practise.algos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class McPredict {

	public static void main(String[] args) throws ParseException {
		
		int [] a = new int [] {4,8,7};
		int [] l = new int [] {2,4};
		int [] h = new int [] {8,4};
		//jobOffers(a, l, h);
		String [] st= {"2013-01-01 07:00"};
		String [] time= {"2013-01-01 08:00"};
		float [] humid = new float [] {(float) 64.45};
		float [] op =predictMissingHumidity("2012-01-01", "2013-12-01", st, humid, time);
		for(float f:op)
			System.out.println(f);
	}
	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		int [] res = new int[lowerLimits.length];
		for(int i=0;i<lowerLimits.length;i++)
		{
			int count = 0;
			for(int score :scores) {
				if(score>= lowerLimits[i] && score <= upperLimits[i])
					count++;
			}
			res[i] =count;
		}
		return res;
    }
	
	static float[] predictMissingHumidity(String startDate, String endDate, String[] knownTimestamps, float[] humidity, String[] timestamps) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		
        float [] ret = new float[timestamps.length];
        try
        {
          Date stdt = sdf.parse(startDate.split(" ")[0]);
        Date eddt = sdf.parse(endDate.split(" ")[0]);
       
        int c = 0;
        for(String timestamp :timestamps)
        {
        	
        	Date testdate = sdf.parse(timestamp.split(" ")[0]);
        	if(stdt.compareTo(testdate)<=0 && eddt.compareTo(testdate)>=0)
        	{
        		float moving_average = 0;
            	int count = 0;
            	for(int i=0;i<knownTimestamps.length;i++)
            	{
            		Date knowntime = time.parse(knownTimestamps[i].split(" ")[1]);
          	        Date testtime = time.parse(timestamp.split(" ")[1]);
          	        Date knownDate = sdf.parse(knownTimestamps[i].split(" ")[0]);
          	      
          	        if(knowntime.compareTo(testtime)<=0 && knownDate.compareTo(testdate)<=0)
          	        {
          	        	
          	        	moving_average+=humidity[i];
          	        	count++;
          	        }
            	}
            	if(count!=0)
            		ret[c]=moving_average/count;
            	else
            		ret[c]=0;
            	c++;
        	}
        	
        } 
        }
        catch(ParseException e)
        {
            System.out.println(e.getMessage());
        }
        
        
		return ret;
    }
	
	  static float[] predictTemperature(String startDate, String endDate, float[] temperature, int n) {
		  float [] ret = new float[24*n];
	       int fact = temperature.length/24;
	       int i=0;
	    	   for(int j=0;j<24;j++)
	    	   {
	    		   for(int k=0;k<fact;k++)
	    		   {
	    			   ret[i]+=temperature[k*24+j];
	    		   }
                  ret[i]=ret[i]/fact;
	    	   i++;
	       }
     
       float [] moving = new float[24*n];
       int l=0;
       for(int j=0;j<24;j++)
	   {
		   for(int k=0;k<fact;k++)
		   {
			   moving[l]+=temperature[k*+j];
		   }
          moving[l]=moving[l]/fact;
	   l++;
   }
	  return moving;

	  }
}
