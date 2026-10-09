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
    public ListNode reverseList(ListNode head) {
        ListNode new_head = null;

        while (head != null) {
            // Store current node's reference to the next node
            ListNode new_head_next = head.next;
            // Change reference of the current node to the new head of the reversed list
            head.next = new_head;
            // Current node becomes the new head of the reversed list
            new_head = head;
            // Change the current node to the next node in the original list
            head = new_head_next;
        }

        return new_head;
    }
}