// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

// 遍历一遍链表，把小于x的都挂到head1后，把大于等于x的都放到head2后，最后再把大于等于的链表挂到小于链表的后面就可以了。


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode lessHead=new ListNode(0);
        ListNode greaterHead=new ListNode(0);
        ListNode node=head;
        ListNode less=lessHead;
        ListNode greater=greaterHead;
        while(node!=null){
            if(node.val<x){
                less.next=node;
                less=less.next;
            }else{
                greater.next=node;
                greater=greater.next;
                
            }
            node=node.next;
        }
        greater.next=null;
        less.next=greaterHead.next;
        return lessHead.next;
    }
}