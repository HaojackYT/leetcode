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

    class NodeState {
        TreeNode node;
        boolean visited;

        NodeState(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, false));

        HashMap<TreeNode, Integer> heights = new HashMap<>();

        while (!stack.isEmpty()) {

            NodeState item = stack.pop();
            TreeNode node = item.node;

            if (!item.visited) {
                stack.push(new NodeState(node, true));

                if (node.right != null) {
                    stack.push(new NodeState(node.right, false));
                }

                if (node.left != null) {
                    stack.push(new NodeState(node.left, false));
                }
            } else {
                int leftHeight = heights.getOrDefault(node.left, 0);
                int rightHeight = heights.getOrDefault(node.right, 0);
                
                if (Math.abs(leftHeight - rightHeight) > 1) {
                    return false;
                }

                heights.put(node, 1 + Integer.max(leftHeight, rightHeight));
            }
        }

        return true;
    }
}