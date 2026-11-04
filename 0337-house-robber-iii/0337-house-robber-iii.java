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

    class Pair<K, V> {
        K first;
        V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public int rob(TreeNode root) {
        Pair<Integer, Integer> answer = robHelper(root);
        return Math.max(answer.first, answer.second);
    }

    public Pair<Integer, Integer> robHelper(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> left_subtree = robHelper(node.left);
        Pair<Integer, Integer> right_subtree = robHelper(node.right);

        int with_root = node.val + left_subtree.second + right_subtree.second;
        int without_root = Math.max(left_subtree.first, left_subtree.second) +
                Math.max(right_subtree.first, right_subtree.second);

        return new Pair<>(with_root, without_root);
    }
}