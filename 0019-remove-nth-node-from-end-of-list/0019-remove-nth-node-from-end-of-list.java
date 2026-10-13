/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;

        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }

        int steps = len - n;
        current = head;
        for (int i = 0; i < steps; i++) {
            prev = current;
            current = current.next;
        }

        // Current pointer is right after the prev pointer
        prev.next = current.next;
        return dummy.next;
    }
}