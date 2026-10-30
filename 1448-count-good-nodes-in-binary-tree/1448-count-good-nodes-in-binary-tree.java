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
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }

    public int goodNodesHelper(TreeNode node, int current_highest_val) {
        if (node == null) {
            return 0;
        }

        int cnt = 0;

        if (node.val >= current_highest_val) {
            cnt++;
            current_highest_val = node.val;
        }

        cnt += goodNodesHelper(node.left, current_highest_val);
        cnt += goodNodesHelper(node.right, current_highest_val);

        return cnt;
    }
}