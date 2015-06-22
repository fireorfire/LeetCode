/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    public ListNode sort(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode shadow = new ListNode(0);
        shadow.next = head;
        ListNode prev = shadow, curr = shadow;
        
        while(curr.next != null) {
            curr = curr.next;
            prev = prev.next;
            if(curr.next != null)
                curr = curr.next;
        }
        ListNode head2 = prev.next;
        prev.next = null;
        head = sort(head);
        head2 = sort(head2);
        return merge(head, head2);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode shadow = new ListNode(0);
        shadow.next = null;
        ListNode curr = shadow;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) curr.next = l1;
        else if(l2 != null) curr.next = l2;
        
        return shadow.next;
    }
}