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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new  ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode previous_level_node = queue.remove();

                level.add(previous_level_node.val);

                if (previous_level_node.left != null) {
                    queue.offer(previous_level_node.left);
                }

                if (previous_level_node.right != null) {
                    queue.offer(previous_level_node.right);
                }
            }
            if (level != null) {
                answer.add(level);
            }
        }

        return answer;
    }
}