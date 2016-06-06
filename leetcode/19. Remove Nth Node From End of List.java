// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.


// 设两个指针 p, q，让 q 先走 n 步，然后 p 和 q 一起走，直到 q 走到尾节点，删除 p->next 即可

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode pFast=newHead;
        ListNode pSlow=newHead;
        
        for(int i=0;i<n;i++){
            pFast=pFast.next;
        }
        
        while(pFast.next!=null){
            pFast=pFast.next;
            pSlow=pSlow.next;
        }
        pSlow.next=pSlow.next.next;
        return newHead.next;
        
    }
}