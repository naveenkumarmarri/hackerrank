package com.leetcode.medium;

public class SwapNodesInPairs {
	public LiNode swapPairs(LiNode head) {
        if(head == null || head.next == null)
            return head;
        LiNode temp = head;
        while(temp.next != null) {       
            /*ListNode second = temp.next;
            temp.next = second.next;
            second.next = temp;
            temp = temp.next.next;*/
            LiNode second = temp;
           second.next = temp;
            temp.next = temp.next;
            temp = temp.next.next;
            //System.out.println(temp.val);
        }
        return head; 
    }
}

 class LiNode {
     int val;
     LiNode next;
     LiNode(int x) { val = x; }
 }