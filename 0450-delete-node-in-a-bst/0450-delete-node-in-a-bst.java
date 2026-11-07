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
// Recursive
// Time & Space Complexity: O(h), worse case h = n

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = deleteNodeHelper(root, key);
        return root;
    }

    public TreeNode deleteNodeHelper(TreeNode node, int key) {

        if (node == null) {
            return node;
        } else if (key < node.val) {
            node.left = deleteNodeHelper(node.left, key);
        } else if (key > node.val) {
            node.right = deleteNodeHelper(node.right, key);
        } else { // key == node.val

            // The current node is a leaf node
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left != null) {
                node.val = predecessor(node);
                node.left = deleteNodeHelper(node.left, node.val);
            } else {
                node.val = successor(node);
                node.right = deleteNodeHelper(node.right, node.val);
            }

        }

        return node;
    }

    public int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

}