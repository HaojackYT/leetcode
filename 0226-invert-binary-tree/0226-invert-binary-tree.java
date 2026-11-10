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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            TreeNode tmp_node_left = node.left;
            node.left = node.right;
            node.right = tmp_node_left;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return root;
    }
}

// Recursion DFS Preorder Traversal
// Time & Space Complexity: O(n)

// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }

//         TreeNode tmp_root_left = root.left;
//         root.left = root.right;
//         root.right = tmp_root_left;

//         invertTree(root.left);
//         invertTree(root.right);

//         return root;
//     }
// }