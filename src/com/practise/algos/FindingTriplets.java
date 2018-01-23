package com.practise.algos;

import java.util.Arrays;

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/

public class FindingTriplets {



		public boolean findTriplets(int arr[] , int n)
	       {
	          Arrays.sort(arr);
	          for(int i =0 ;i<arr.length; i++) {
	              for(int j = i+1; j<arr.length;j++) {
	                  int temp = search(arr, -(arr[i]+arr[j]), 0, arr.length-1);
	                  if(temp != -1 && temp != i && temp !=j ) {
	                      return true;
	                      
	                  }
	              }
	          }
	          return false;
	       }
	       
	       public int search(int arr[], int n, int low, int high) {
	           if(low <= high) {
	               int mid = Math.floorDiv((low+high), 2);
	               if(arr[mid] == n)
	                    return mid;
	                else if(arr[mid] > n) {
	                    return search(arr, n, low, mid-1);
	                }
	                else
	                    return search(arr, n, mid+1, high);
	           }
	           
	           return -1;
	       }
	       
	       
	}

