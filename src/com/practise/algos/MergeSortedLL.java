package com.practise.algos;

public class MergeSortedLL {
	
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	    {
	       
	            
	        ListNode merged = new ListNode(0);
	        ListNode big = merged;
	            

	        while(l1!=null || l2!=null)
	        {
	          if(l1==null && l2!=null)
	          {
	             ListNode new_ = new ListNode(l2.val);
	            if(merged == null)
	                merged = new_;
	            else
	                merged.next = new_;
	             new_.next = null;
	              l2 = l2.next;
	              
	              merged = merged.next;
	              System.out.println(big);
	          }
	          if(l2==null && l1!=null)
	          {
	              ListNode new_ = new ListNode(l1.val);
	              if(merged == null)
	                merged = new_;
	            else
	                merged.next = new_;
	              new_.next = null;
	              l1 = l1.next;
	              merged = merged.next;
	          }
	          if(l1!=null && l2!=null)
	          {
	              if(l1.val>l2.val)
	              {
	                  ListNode new_ = new ListNode(l2.val);
	                  if(merged == null)
	                merged = new_;
	            else
	                merged.next = new_;
	                  new_.next = null;
	                  l2 = l2.next;
	                  merged = merged.next;
	              }
	              else
	              {
	                  ListNode new_ = new ListNode(l1.val);
	                  if(merged == null)
	                    merged = new_;
	                  else
	                    merged.next = new_;
	                  new_.next = null;
	                  l1 = l1.next;
	                  merged = merged.next;
	              }
	          }
	              
	        }
	        
	        return big.next;
	}
	    public class ListNode {
	    	      int val;
	    	      public ListNode next;
	    	      ListNode(int x) { val = x; }
	    	 }
}

