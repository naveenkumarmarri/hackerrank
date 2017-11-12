import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k=sc.nextLong();
		long [] items=new long[n];
		
		long count=0;
		long first=0,second=0;
		for(int l=0;l<n;l++)
		{
			items[l]=sc.nextLong();
			if(items[l]==1)
			{
				count++;
			}
			if(first==0)
			{
				first=l+1;
			}
			else
			{
				second=l+1;
				break;
			}
		}
		
		long first_min = (first+(second-first)*k);
		
		long second_min = (minDist(items,items.length,items[0],items[items.length-1],k));
		if(first_min<second_min)
			System.out.println(first_min);
		else
			System.out.println(second_min);
	}


	public static long minDist(long[] items, int n, long items2, long items3,long k) 
    {
        int i, j;
        int first=0,second=0;
        int min_dist = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) 
        {
            for (j = i + 1; j < n; j++) 
            {
                if ((items2 == items[i] && items3 == items[j]
                    || items3 == items[i] && items2 == items[j])
                    && min_dist > Math.abs(i - j)) 
                {
                	min_dist = Math.abs(i - j);
                	first=i;second=j;
                	
                }
                    
            }
        }
        return first+min_dist+k;
    }


}