class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int max_capacity;
    int current_capacity;
    HashMap<Integer, Node> hashMap = new HashMap<>();
    Node least_recently_used;
    Node most_recently_used;

    public LRUCache(int capacity) {
        this.max_capacity = capacity;
        this.current_capacity = 0;
    }

    public int get(int key) {
        Node current_node = hashMap.get(key);

        if (current_node == null) {
            return -1;
        }

        moveToMostRecentlyUsed(current_node);
        return current_node.val;
    }

    public void put(int key, int value) {
        Node current_node = hashMap.get(key);

        // If the key already exists, update the existing node value
        if (current_node != null) {
            current_node.val = value;
            moveToMostRecentlyUsed(current_node);
            return;
        }

        // If the current capacity is full, evict the least recently used node
        if (current_capacity == max_capacity) {
            Node remove_node = least_recently_used;

            hashMap.remove(remove_node.key);
            removeNode(remove_node);
            current_capacity--;
        }

        // Create and add the new node to the most recently used
        Node new_node = new Node(key, value);
        hashMap.put(key, new_node);
        addToMostRecentlyUsed(new_node);
        current_capacity++;
    }

    private void moveToMostRecentlyUsed(Node node) {
        // If the node is already the most recently used, no need to move it
        if (most_recently_used == node) {
            return;
        }

        removeNode(node);
        addToMostRecentlyUsed(node);
    }

    private void addToMostRecentlyUsed(Node node) {
        node.prev = most_recently_used;
        node.next = null;

        if (most_recently_used != null) {
            most_recently_used.next = node;
        } else {
            least_recently_used = node;
        }

        most_recently_used = node;
    }

    private void removeNode(Node node) {
        // If the node is not the least recently used node, update its neighbors
        if (node.prev != null) {
            // Update the next pointer of the previous node of the removed node to
            // the next node of the removed node
            node.prev.next = node.next;
        } else { // The removed node is the least recently used node
            // Update the least recently used pointer to
            // the next node of the removed node
            least_recently_used = node.next;
        }

        // If the node is not the most recently used node, update its neighbors
        if (node.next != null) {
            // Update the previous pointer of the next node of the removed node to
            // the previous node of the removed node
            node.next.prev = node.prev;
        } else { // The removed node is the most recently used node
            // Update the most recently used pointer to
            // the previous node of the removed node
            most_recently_used = node.prev;
        }

        // Detach the removed node from the doubly linked list
        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */