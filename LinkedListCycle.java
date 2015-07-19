/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode slow = fake, fast = fake;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == slow) return true;
        }
        return false;
    }
}