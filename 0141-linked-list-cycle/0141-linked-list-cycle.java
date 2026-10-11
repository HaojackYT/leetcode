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
        
        if (head == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode current = head;

        while (!hashSet.contains(current.val)) {
            
            if (current.next == null) {
                return false;
            }

            if (hashSet.contains(current.next)) {
                return true;
            }

            hashSet.add(current);
            current = current.next;
        }

        return false;
    }
}