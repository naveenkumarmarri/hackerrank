package com.leetcode.medium;

public class removeNthFromEndLL {

	    public LinkNode removeNthFromEnd(LinkNode head, int n) {
	        if(head == null || head.next == null)
	            return null;
	        int len = 0;
	        LinkNode temp = head;
	        while(temp != null) {
	            len += 1;
	            temp = temp.next;
	        }
	        /*
	        delete head node
	        */
	        if(n == len) {     
	            return head.next;
	        }
	        else if(n == 1){
	            LinkNode t = head;
	            while(t.next.next != null) {
	                t = t.next;
	            }
	            t.next = null;
	            return head;
	        }
	        else {
	            LinkNode x = head;
	            while(len != n+1) {
	                x = x.next;
	                len--;
	            }
	            LinkNode curr = x;
	            LinkNode next = curr.next.next;
	            curr.next = next;
	            return head;
	        }
	        
	    }
	}

 class LinkNode {
     int val;
     LinkNode next;
     LinkNode(int x) { val = x; }
 }


