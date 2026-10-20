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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<NodeState> stack = new Stack<>();
        Map<TreeNode, Integer> heights = new HashMap<>();
        // root = [1,2,3,4,5]
        stack.push(new NodeState(root, false));

        int diameter = 0;
        while (!stack.isEmpty()) {
            // stack = [(root, false)]

            NodeState item = stack.pop();
            TreeNode node = item.node;

            if (!item.visited) {
                // The current node's visited = false, so visit its children nodes first
                stack.push(new NodeState(node, true));

                if (node.right != null) {
                    stack.push(new NodeState(node.right, false));
                }

                if (node.left != null) {
                    stack.push(new NodeState(node.left, false));
                }

                // stack = [(root, true), (3, false), (2, false)]
                // stack = [(root, true), (3, false), (2, true), (5, false), (4, false)]
            } else {
                // The heights of the children nodes of the current node's visited = true
                int leftHeight = heights.getOrDefault(node.left, 0);
                int rightHeight = heights.getOrDefault(node.right, 0);

                // Current longest diameter from the current node to its children nodes
                diameter = Math.max(diameter, leftHeight + rightHeight);

                // Height of the current node's visited = true in the tree
                heights.put(node, 1 + Math.max(leftHeight, rightHeight));
            }
        }

        return diameter;
    }
}