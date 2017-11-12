import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HyperSpaceHR {

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm= br.readLine();
        String[] inp_num =nm.split(" ");
        int n = Integer.parseInt(inp_num[0]);
        int m = Integer.parseInt(inp_num[1]);
        String[] inp_values = new String[n];
        int[][] dimension_values=new int[n][m];
        for(int i =0;i<n;i++)
        {
        	inp_values[i]=br.readLine();
        	String [] values = inp_values[i].split(" ");
        	for(int j=0;j<m;j++)
        	{
        		
        		dimension_values[i][j]=Integer.parseInt(values[j]);
        	}
        }
        int [][] dimension_result=new int[n][n];
        int [] row_sum_array=new int[n];
        for(int l=0;l<n;l++)
        {
        	int row_sum=0;
        	for(int k=0;k<n;k++)
        	{
        		if(l==k)
        			dimension_result[l][k]=0;
        		else
        			dimension_result[l][k]=findDistance(dimension_values[l],dimension_values[k]);
        		row_sum=row_sum+dimension_result[l][k];
        	}
        	row_sum_array[l]=row_sum;
        }
        int temp=row_sum_array[0];
        int x=0;
        for( x=1;x<row_sum_array.length;x++)
        {
        	if(temp>row_sum_array[x])
        		temp=row_sum_array[x];
        }
        int count=0,loc=0;
       for(int y=0;y<n;y++)
       {
    	   if(row_sum_array[y]==temp)
    	   {
    		  count++;
    		  loc=y;
    	   }
       }
       if(count==1)
    	   System.out.println(inp_values[loc]);
       else
       {
    	   
       }
        	
    }

	private static int findDistance(int[] is, int[] is2) {
		int sum=0;
		for(int i=0;i<is.length;i++)
		{
			sum=sum+is[i]-is2[i];
		}
		if(sum<0)
			return -(sum);
		return sum;
	}
}