package com.leetcode.medium;


// * Definition for singly-linked list.
  class LLNode {
      int val;
      LLNode next;
      LLNode(int x) { val = x; }
  }
 
public class AddTwoNumbersLL{
    public LLNode addTwoNumbers(LLNode l1, LLNode l2) {
        int carry = 0;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        LLNode head = null;
        LLNode curr = head;
        while(l1 != null && l2 != null) {
            int curr_sum = l1.val + l2.val + carry;
            carry = curr_sum / 10;
            if(carry > 0) {
                curr_sum = curr_sum % 10;
            }
            if(head == null) {
                head = new LLNode(curr_sum);
                head.next = null;
                curr = head;
            }
            else {
                LLNode temp = new LLNode(curr_sum);
                temp.next = null;
                curr.next = temp;
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int curr_sum = l1.val + carry;
            carry = curr_sum / 10;
            if(carry > 0)
                curr_sum = curr_sum % 10;
            
            LLNode temp = new LLNode(curr_sum);
            temp.next = null;
            curr.next = temp;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int curr_sum = l2.val + carry;
            carry = curr_sum / 10;
            if(carry > 0)
                curr_sum = curr_sum % 10;
            
            LLNode temp = new LLNode(curr_sum);
            temp.next = null;
            curr.next = temp;
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry > 0) {
            LLNode temp = new LLNode(carry);
            temp.next = null;
            curr.next = temp;
           // curr = curr.next;
        }
        return head;
    }
   
}
