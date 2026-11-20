/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Iterative BST Search + In-order successor
// Time complexity: O(h)
// Space complexity: O(1)

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 1. Search for the node to remove
        TreeNode current = root, parent = null;
        while (current != null && current.val != key) {
            parent = current;
            if (current.val > key) {
                current = current.left;
            } else { // current.val < key
                current = current.right;
            }
        }
        // current.val = key

        // 2. If the node is found, delete the node

        // Case 1: The root node is the one to be deleted
        if (parent == null) {
            return delete(current);
        }

        // Case 2: The left child of `parent` is the node to be deleted
        if (parent.left == current) {
            parent.left = delete(current);
        }
        // Case 3: The right child of `parent` is the node to be deleted
        else {
            parent.right = delete(current);
        }

        return root;
    }

    private TreeNode delete(TreeNode node) {
        if (node == null) {
            return null;
        }

        // Case 1: The node is a leaf node
        // Case 2: The node only has the right child
        if (node.left == null) {
            return node.right;
        }

        // Case 3: The node only has the left child
        if (node.right == null) {
            return node.left;
        }

        // Case 4: The node has both left and right children

        // Case 4.1: successor is the direct right child of the node to be deleted
        TreeNode successor = node.right;
        TreeNode parent = null;
        while (successor.left != null) {
            parent = successor;
            successor = successor.left;
        }
        // successor is the smallest node in the right subtree of the node to be deleted
        successor.left = node.left;

        // Case 4.2: successor is not the direct right child of the node to be deleted
        // (successor is deep in the right subtree of the node to be deleted)
        // successor doesn't have left subtree due to it is the leftmost node in
        // the right subtree, but it still may have right subtree
        if (successor != node.right) {
            // Connect the right subtree of the successor to the left of its parent
            parent.left = successor.right;
            // Connect the right subtree of the node to be deleted to
            // the right of the successor
            successor.right = node.right;
        }

        return successor;
    }
}

// Recursive In-order successor and predecessor
// Time & Space Complexity: O(h)

// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         root = deleteNodeHelper(root, key);
//         return root;
//     }

//     public TreeNode deleteNodeHelper(TreeNode node, int key) {

//         if (node == null) {
//             return node;
//         } else if (key < node.val) {
//             node.left = deleteNodeHelper(node.left, key);
//         } else if (key > node.val) {
//             node.right = deleteNodeHelper(node.right, key);
//         } else { // key == node.val

//             // The current node is a leaf node
//             if (node.left == null && node.right == null) {
//                 node = null;
//             } else if (node.left != null) {
//                 node.val = predecessor(node);
//                 node.left = deleteNodeHelper(node.left, node.val);
//             } else {
//                 node.val = successor(node);
//                 node.right = deleteNodeHelper(node.right, node.val);
//             }

//         }

//         return node;
//     }

//     public int predecessor(TreeNode node) {
//         node = node.left;
//         while (node.right != null) {
//             node = node.right;
//         }
//         return node.val;
//     }

//     public int successor(TreeNode node) {
//         node = node.right;
//         while (node.left != null) {
//             node = node.left;
//         }
//         return node.val;
//     }

// }