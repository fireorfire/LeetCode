/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode shadow = new ListNode(0);
        shadow.next = head;
        ListNode prev = shadow, curr = head;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                while(curr.next != null && curr.val == curr.next.val)
                    curr = curr.next;
                prev.next = curr.next;
                curr = curr.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return shadow.next;
    }
}