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

    class NodeLevel {
        TreeNode node;
        int level;

        NodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();
        Stack<NodeLevel> stack = new Stack<>();
        stack.push(new NodeLevel(root, 0));

        int current_highest_level = -1;
        while (!stack.isEmpty()) {
            NodeLevel item = stack.pop();
            TreeNode current_node = item.node;
            int current_level = item.level;

            if (current_highest_level < current_level) {
                answer.add(current_node.val);
                current_highest_level = current_level;
            }

            if (current_node.left != null) {
                stack.push(new NodeLevel(current_node.left, current_level + 1));
            }

            if (current_node.right != null) {
                stack.push(new NodeLevel(current_node.right, current_level + 1));
            }
        }

        return answer;
    }
}