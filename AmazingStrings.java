
public class AmazingStrings {

	public static void main(String[] args) {
		String[] inp =new String[3];
		inp[0]="aab";
		inp[1]="aaabccc";
		inp[2]="aaabb";
		for(int i:numChanges(inp))
			System.out.println(i);
	}

	private static int[] numChanges(String[] inp) {
		int [] res = new int[inp.length];
		int l=0;
		for(String s:inp)
		{
			char[] input=s.toCharArray();
			int count=0;
			for(int i=0;i<input.length-1;i++)
			{
				if((input[i]==input[i+1]))
				{
					i++;
					count++;
				}
			}
			res[l]=count;
		}
		
		return res;
	}
	
}
