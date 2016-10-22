import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args)throws ConcurrentModificationException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] ele=new int[n];
        for(int i=0;i<n;i++)
        	ele[i]=sc.nextInt();
        ArrayList<Integer> al = (ArrayList<Integer>) Arrays.stream(ele)
        .boxed()
        .collect(Collectors.toList());
        int x = getMin(al);
        int total_count=0;
        while(al.size()>=1){
        	al = numBetween(al,x,x+4);
        	if(al.size()>0)
        	  x = getMin(al);
        	total_count++;
        }
        System.out.println(total_count);
    	
    }

	private static ArrayList<Integer> numBetween(ArrayList<Integer> ele, int x, int i) {
		int temp=0;
		

		for(int j=x;j<=x+4;j++)
		{
			Iterator<Integer> iter = ele.iterator();
			while (iter.hasNext()) {
			    int str = iter.next();

			    if (str==j)
			        iter.remove();
			}
		}
		return ele;
	}

	private static int getMin(ArrayList<Integer> elem) {
		int min=elem.get(0);
		for(int i:elem)
		{
			if(i<min)
				min=i;
		}
		return min;
	}
    
}