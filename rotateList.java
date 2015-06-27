/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int count = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            count++;
        }
        k = k % count;
        if(k == 0) return head;
        ListNode curr = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        int step = 0;
        while(step < (count - k)) {
            prev = curr;
            curr = curr.next;
            step++;
        }
        prev.next = null;
        tail.next = head;
        return curr;
    }
}