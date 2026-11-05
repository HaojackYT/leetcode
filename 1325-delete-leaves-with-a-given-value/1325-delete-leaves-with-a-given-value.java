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
// Recursive DFS post-order traversal
// Time & Space Complexity: O(n)

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeafNodesHelper(root, target);
    }

    public TreeNode removeLeafNodesHelper(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = removeLeafNodesHelper(node.left, target);
        node.right = removeLeafNodesHelper(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        } else {
            return node;
        }
    }
}