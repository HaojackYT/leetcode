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

    class NodeRange {
        TreeNode node;
        long min;
        long max;

        NodeRange(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<NodeRange> queue = new ArrayDeque<>();

        queue.offer(new NodeRange(
            root,
            Long.MIN_VALUE,
            Long.MAX_VALUE
        ));

        while (!queue.isEmpty()) {

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                NodeRange item = queue.remove();

                TreeNode node = item.node;
                long min = item.min;
                long max = item.max;

                // Check whether the current node is within its valid range
                if (node.val <= min || node.val >= max) {
                    return false;
                }

                // Left subtree: all values must be smaller than the current node
                if (node.left != null) {
                    queue.offer(new NodeRange(
                        node.left,
                        min,
                        node.val
                    ));
                }

                // Right subtree: all values must be greater than the current node
                if (node.right != null) {
                    queue.offer(new NodeRange(
                        node.right,
                        node.val,
                        max
                    ));
                }
            }
        }

        return true;
    }
}
