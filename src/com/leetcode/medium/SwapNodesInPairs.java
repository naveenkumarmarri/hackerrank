package com.leetcode.medium;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        while(temp.next != null) {       
            /*ListNode second = temp.next;
            temp.next = second.next;
            second.next = temp;
            temp = temp.next.next;*/
            ListNode second = temp;
           second.next = temp;
            temp.next = temp.next;
            temp = temp.next.next;
            //System.out.println(temp.val);
        }
        return head; 
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }