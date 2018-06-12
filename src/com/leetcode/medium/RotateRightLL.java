package com.leetcode.medium;

import com.practise.algos.MergeSortedLL.ListNode;

public class RotateRightLL {

	    public ListNode rotateRight(ListNode head, int k) {
	        ListNode temp = head;
	        int len_ = len(head);
	        if(len_ == 0)
	            return head;
	        k = k % len_;
	        for(int i=0;i<k;i++) {
	            temp = swap(temp);
	            ListNode x= temp;
	        }
	        return temp;
	    }
	    public int len(ListNode node) {
	        int len=0;
	        while(node != null) {
	            node = node.next;
	            len +=1;
	        }
	        return len;
	    }
	    public ListNode swap(ListNode node) {
	        if(node == null || node.next == null)
	            return node;
	        
	        else if(node.next.next == null) {
	            ListNode first = node;
	            ListNode second = node.next;
	            node = second;
	            node.next = first;
	            first.next = null;
	            return node;
	        }
	        else {
	            ListNode temp = node;
	            while(temp.next.next != null) {
	                temp = temp.next;
	            }    
	            ListNode last = temp.next;
	            ListNode first = node;
	            
	            last.next = first;
	            temp.next = null;
	            
	            return last;
	            
	        }
	        
	    }
	}
