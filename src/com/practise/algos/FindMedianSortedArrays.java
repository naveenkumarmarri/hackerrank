package com.practise.algos;

public class FindMedianSortedArrays {
	
	  public double findMedianSortedArrays(int[] nums1, int[] nums2)
	    {
	        int [] merged = new int[nums1.length+nums2.length];
	        int j=0;
	        int k = 0;
	        if(merged.length==0)
	            return 0;
	        for(int i=0;i<merged.length;i++)
	        {
	            
	            if(j>=nums1.length)
	            {
	                if(!(k>=nums2.length))
	                    merged[i]=nums2[k];
	                k++;
	            }
	                
	            if(k>=nums2.length)
	            {
	                if(!(j>=nums1.length))
	                    merged[i]=nums1[j];
	                j++;
	            }
	                
	            
	            if(j<nums1.length && k<nums2.length){
	                
	                if(nums1[j]<nums2[k])
	                {
	                    merged[i] = nums1[j];
	                    j++;
	                }
	                else
	                {
	                    merged[i] = nums2[k];
	                    k++;
	                }
	                    
	            }
	                
	        }
	        for(int i:merged)
	        System.out.println(i);
	        System.out.println(j+" "+k);
	        if(merged.length%2==0)
	        {
	            return (merged[(merged.length)/2]+merged[merged.length/2-1])/2.0;
	        }
	        else
	            return merged[merged.length/2];
	        
	    }

}
