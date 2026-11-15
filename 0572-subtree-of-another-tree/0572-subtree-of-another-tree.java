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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubtreeHelper(root, subRoot);
    }

    public boolean isSubtreeHelper(TreeNode root, TreeNode subRoot) {    
        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtreeHelper(root.left, subRoot) ||
                isSubtreeHelper(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root_node, TreeNode sub_node) {
        if (root_node == null && sub_node == null) {
            return true;
        }

        if (root_node == null || sub_node == null || root_node.val != sub_node.val) {
            return false;
        }

        return isSameTree(root_node.left, sub_node.left) &&
                isSameTree(root_node.right, sub_node.right);
    }
}