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
// Iterative DFS Preorder Traversal
// Time & Space Complexity: O(n)

class Solution {

    class NodeState {
        TreeNode node;
        int current_highest_val;

        NodeState(TreeNode node, int current_highest_val) {
            this.node = node;
            this.current_highest_val = current_highest_val;
        }
    }

    public int goodNodes(TreeNode root) {
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, root.val));

        int cnt = 0;
        while (!stack.isEmpty()) {
            NodeState item = stack.pop();
            TreeNode node = item.node;
            int current_highest_val = item.current_highest_val;

            if (node.val >= current_highest_val) {
                cnt++;
                current_highest_val = node.val;
            }

            if (node.right != null) {
                stack.push(new NodeState(node.right, current_highest_val));
            }

            if (node.left != null) {
                stack.push(new NodeState(node.left, current_highest_val));
            }
        }

        return cnt;
    }
}

// Recursion DFS Preorder Traversal
// Time & Space Complexity: O(n)

// class Solution {
//     public int goodNodes(TreeNode root) {
//         return goodNodesHelper(root, root.val);
//     }

//     public int goodNodesHelper(TreeNode node, int current_highest_val) {
//         if (node == null) {
//             return 0;
//         }

//         int cnt = 0;

//         if (node.val >= current_highest_val) {
//             cnt++;
//             current_highest_val = node.val;
//         }

//         cnt += goodNodesHelper(node.left, current_highest_val);
//         cnt += goodNodesHelper(node.right, current_highest_val);

//         return cnt;
//     }
// }