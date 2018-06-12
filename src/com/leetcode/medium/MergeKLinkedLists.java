package com.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.*/
  class LNode {
      int val;
      LNode next;
      LNode(int x) { val = x; }
  }
 
class MergeKLinkedLists {
    public LNode mergeKLists(LNode[] lists) {
    	  if(lists.length == 0 )
              return null;
          if(lists.length == 1)
              return lists[0];
          PriorityQueue<LNode> pq = new PriorityQueue<LNode>(new check());
          for(LNode node:lists) {
        	  LNode head = node;
              while(head != null) {
                  pq.add(head);
                  head = head.next;
              }
          }
          LNode head = null;
          if(pq.size() > 0) {
              head = new LNode(pq.poll().val);
              head.next = null;
          }
          LNode curr = head;
          while(pq.size() > 0) {
        	  LNode temp = new LNode(pq.poll().val);
              temp.next = null;
              curr.next = temp;
              curr = curr.next;
          }
          
          return head;
    }
    
    
}
class check implements Comparator<LNode> {
    @Override
    public int compare(LNode o1, LNode o2) {
        return o1.val - o2.val;
    }
}