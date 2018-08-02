
public class QuickSort {
	public static void main(String[] args) {
		int[]a = new int[] {5,1,2,3,2,3,-1};
		quickSort(a, 0, a.length-1);
		for(int i:a)
			System.out.println(i);
	}

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
	    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}    

	public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
		if (start > end) return Integer.MAX_VALUE;
		
		int pivot = nums[end];// Take A[end] as the pivot, 
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
				swap(nums, left++, i);			
		}
		swap(nums, left, end);// Finally, swap A[end] with A[left]
		
		if (left == k)// Found kth smallest number
			return nums[left];
		else if (left < k)// Check right part
			return findKthLargest(nums, left + 1, end, k);
		else // Check left part
			return findKthLargest(nums, start, left - 1, k);
	} 

	

	private static int decPartition(int[] a, int low, int high) {
		int pivot  = a[low];
		int start = high+1;
		for(int i=high-1;i>=0;i--) {
			if(a[i] >= pivot) {
				start--;
				swap(a, i, start);
			}
		}
		start--;
		swap(a, low, start);
		return start;
	}

	private static void quickSort(int[] a, int low, int high) {
		
		if(low < high) {
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot-1);
			quickSort(a, pivot+1, high);
		}
		
		
	}

	private static int partition(int[] a, int low, int high) {
		int start = low-1;
		int pivot = a[high];
		for(int i=low; i<high; i++) {
			if(a[i] <= pivot) {
				start+=1;
				swap(a, start, i);
			}
		}
		start++;
		swap(a, start, high);
		return start;
		
	}

	private static void swap(int[] a, int start, int i) {
		int temp = a[start];
		a[start] = a[i];
		a[i] = temp;
	}
}
