import java.io.*;
import java.util.*;

public class Heap {
	public static void main(String[] args) {

		int [] a = {1,2,3,4,5,6,-2,4,8,-9};
		int [] test = new int[a.length];
		a = buildMaxHeap(a,a.length);

		//System.out.println(pop(test));
		while(a.length!=0)
		{
			a=pop(a);
		}

	}


	public static int[] buildMaxHeap (int Arr[ ], int n)
	{

		for(int i = n/2 ; i >=0 ; i-- )
		{
			maxHeapify (Arr, i,n) ;
		}
		return Arr;
	}	

	public static int[] maxHeapify (int Arr[ ], int i, int N)
	{
		int largest = i;
		int left = 2*i+1  ;                 //left child
		int right = 2*i+2  ;         //right child;

		if(left<= N-1 && Arr[left] > Arr[i] )
			largest = left;
		else
			largest = i;
		if(right <= N-1 && Arr[right] > Arr[largest] )
			largest = right;
		if(largest != i )
		{
			int temp;
			temp = Arr[i];
			Arr[i]=Arr[largest];
			Arr[largest]=temp;
			maxHeapify (Arr, largest,N-1);
		} 

		return Arr;

	}

	public static int[] pop(int Arr[])
	{
		int return_value = Arr[0];
		Arr[0]=Arr[Arr.length-1];
		int [] test = new int[Arr.length-1];
		for(int i=0;i<test.length;i++)
			test[i] = Arr[i];
		test  = buildMaxHeap(test,test.length);
		System.out.println(return_value);
		return test;

	}


}