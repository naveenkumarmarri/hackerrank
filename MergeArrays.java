
public class MergeArrays {

	public static void main(String[] args) {
		int [] a = {1,2,3,4,5};
		int [] b = {2,3,6,7,8,9};
		int [] c= merge (a,b);
		for(int cd:c)
		{
			System.out.println(cd);
		}
	}
	public static int[] merge(int[] a, int[] b) {
	    int[] answer = new int[a.length + b.length];
	    int i = a.length - 1, j = b.length - 1, k = answer.length;

	    while (k > 0)
	        answer[--k] = 
	            (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
		return answer;
	}
}
