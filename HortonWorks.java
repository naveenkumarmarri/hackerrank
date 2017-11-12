import java.util.Scanner;
import java.util.regex.Pattern;

public class HortonWorks {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] words = new String[n];
		for(int i=0;i<n;i++)
		{
			words[i]=sc.nextLine();
			
		}
		
		System.out.println(adorableCount(words));
	}
	public static int[] adorableCount(String[] words)
	{
		int iteration=0;
		int [] array_num = new int[words.length];
		for(String word:words)
		{
			
			int count=0;
			char[] tokens = word.toCharArray();
			
			for(int i=0;i<tokens.length;i++)
			{
				for(int j=i+1;j<tokens.length+1;j++)
				{
					if(patternMatcher(word.substring(i, j).toString())){
						count++;
						System.out.println(word.substring(i, j).toString());
					}
						
				}
			}
			array_num[iteration]=count;
			
		}
		return array_num;
		
	}
	private static boolean patternMatcher(String string) {
		return Pattern.matches("^[a-z][a-z0-9:]*/[a-z0-9]+\\\\[a-z]+", string);
		
	}
}
