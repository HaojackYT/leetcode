/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the original linked list
        ListNode slow = head;
        ListNode fast = head;
        // Fast pointer has double the speed of the slow pointer,
        // so when the fast pointer reaches the end of the linked list,
        // the slow pointer will be at the middle (n/2) of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the linked list into two parts
        // The first half [0, n/2], the second half [n/2 + 1, n - 1]
        ListNode tmp = slow.next;
        slow.next = null;

        // Step 3: Reverse the second half of the linked list
        ListNode reverse = null;
        while (tmp != null) {
            ListNode tmp_next = tmp.next;
            tmp.next = reverse;
            reverse = tmp;
            tmp = tmp_next;
        }

        // Step 4: Merge the two halves alternately
        ListNode first = head;
        while (reverse != null) {
            // head = [1,2,3,4,5]
            // first_next: [2] -> [3] -> null
            // reverse_next: [4] -> null
            ListNode first_next = first.next;
            ListNode reverse_next = reverse.next;

            first.next = reverse;
            reverse.next = first_next;

            first = first_next;
            reverse = reverse_next;
        }
    }
}