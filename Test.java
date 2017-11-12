import java.util.ArrayList;
import java.util.Scanner;

class Test
{
    
 
    
	public static void main (String args[])
    {
		Scanner sc = new Scanner(System.in);
          //int n =sc.nextInt();
          int [] set = new int[]{1,2,4,8,16,32,64};
          String [] map = new String[] {"Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday"};
          String s = "1001011";
          System.out.println(s.substring(3, s.length()));
         //sumToTarget(set,map,0,0,n,"");
          
    }
    
    public static void sumToTarget(int []elements,String[] map,int index,int sumSoFar,int targetSum,String result)
    {
    	//if the iteration exhausts the bounds it returns
    	if(elements.length<index||sumSoFar>targetSum)
    		return ;
    	
    	for(int i=index;i<elements.length;i++)
    	{
    		//if the sum matches the total sum prints the element which added upto the sum
    		if(sumSoFar+elements[i]==targetSum)
    		{
    			
    			System.out.println(result+" "+map[i]);
    		}
    		else if(sumSoFar+elements[i]<targetSum)
    		{
    			if(result.length()==0)
    				sumToTarget(elements,map, i+1, sumSoFar+elements[i], targetSum, result+""+map[i]);
    			else
    				sumToTarget(elements,map, i+1, sumSoFar+elements[i], targetSum, result+" "+map[i]);
    		}
    	}
    	
    }
}