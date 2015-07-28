/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode mid = fake, tail = fake;
        while(tail.next != null) {
            tail = tail.next;
            mid = mid.next;
            if(tail.next != null) {
                tail = tail.next;
            }
        }
        ListNode prev = mid.next, cur = prev.next;
        mid.next = null;
        prev.next = null;
        while(cur != null) {
            ListNode tem = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tem;
        }
        ListNode start = head;
        while(start != null && prev != null) {
            if(start.val != prev.val) return false;
            start = start.next;
            prev = prev.next;
        }
        return true;
    }
}