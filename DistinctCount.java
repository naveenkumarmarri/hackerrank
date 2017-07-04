import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class DistinctCount {
	
	public static void main(String[] args) {
		

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
        		int n=s.nextInt();
        		int x=s.nextInt();
        		Set<Integer> set = new TreeSet<Integer>();
        		for(int j=0;j<n;j++)
        		{
        			set.add(s.nextInt());
        		}
        		if(set.size()>x)
        			System.out.println("Average");
        		else if(set.size()==x)
        			System.out.println("GOOD");
        		else
        			System.out.println("BAD");
        }
    }
}
