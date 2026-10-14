/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        
        HashMap<Node, Node> hashMap = new HashMap<>();
        while (current != null) {
            hashMap.put(current, new Node(current.val));
            current = current.next;
        }
        hashMap.put(null, null);

        current = head;
        while (current != null) {
            Node duplicate = hashMap.get(current);

            duplicate.next = hashMap.get(current.next);
            duplicate.random = hashMap.get(current.random);

            current = current.next;
        }

        current = head;
        Node new_head = hashMap.get(current);

        return new_head;
    }
}