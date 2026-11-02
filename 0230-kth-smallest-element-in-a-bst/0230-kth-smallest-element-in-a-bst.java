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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, false));

        while(!stack.isEmpty()) {
            NodeState item = stack.pop();
            TreeNode node = item.node;

            if (!item.visited) {
                
                if (node.right != null) {
                    stack.push(new NodeState(node.right, false));
                }

                stack.push(new NodeState(node, true));

                if (node.left != null) {
                    stack.push(new NodeState(node.left, false));
                }

            } else {
                list.add(node.val);
            }
        }

        return list.get(k - 1);
    }
}