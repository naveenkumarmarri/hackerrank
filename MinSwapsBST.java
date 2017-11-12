import java.util.Scanner;

public class MinSwapsBST {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int [] ele=new int[N];
        int count=0;
        for (int i = 0; i < N; i++) {
            ele[i]=s.nextInt();
        }
        for(int i=0;i<N;i++)
        {
        	if(2*i+1<N){
        		if(ele[i]<=ele[2*i+1]){
            		int temp=ele[i];
            		ele[i]=ele[2*i+1];
            		ele[2*i+1]=temp;
            		count++;
            	}
        	}
        	if(2*i+2<N)
        	{
        		if(ele[i]>ele[2*i+2]){
            		int temp=ele[i];
            		ele[i]=ele[2*i+2];
            		ele[2*i+2]=temp;
            		count++;
            	}
        	}
        	
        }
        System.out.println(count);

	}

	private static void swap(int i, int j) {
		int temp=i;
		i=j;
		j=temp;
		
	}

}
