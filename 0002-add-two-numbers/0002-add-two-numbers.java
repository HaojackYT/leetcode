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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode current = answer;

        int carry = 0;
        int addend_1, addend_2;
        while ((l1 != null || l2 != null) || carry != 0) {

            if (l1 == null) {
                addend_1 = 0;
            } else {
                addend_1 = l1.val;
            }

            if (l2 == null) {
                addend_2 = 0;
            } else {
                addend_2 = l2.val;
            }
                
            int total = addend_1 + addend_2 + carry;
            carry = total / 10;

            current.next = new ListNode(total % 10);

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            current = current.next;
        }

        return answer.next;
    }
}