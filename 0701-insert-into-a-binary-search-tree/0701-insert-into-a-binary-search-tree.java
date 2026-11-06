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
// Recursive DFS
// Time & Space Complexity: O(h), worst case h = n

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insertIntoBSTHelper(root, val);
        return root;
    }

    public TreeNode insertIntoBSTHelper(TreeNode node, int val) {

        if (node == null) {
            node = new TreeNode(val, null, null);
        } else if (val < node.val) {
            node.left = insertIntoBSTHelper(node.left, val);
        } else {
            node.right = insertIntoBSTHelper(node.right, val);
        }

        return node;
    }
}