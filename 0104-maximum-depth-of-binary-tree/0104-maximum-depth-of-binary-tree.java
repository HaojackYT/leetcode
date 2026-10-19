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

// Interative DFS (Preorder)

class Solution {

    class NodeDepth {
        TreeNode node;
        int depth;

        NodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Stack<NodeDepth> stack = new Stack<>();
        stack.push(new NodeDepth(root, 1));
        while (!stack.isEmpty()) {

            NodeDepth item = stack.pop();
            TreeNode node = item.node;
            int depth = item.depth;
            level = Integer.max(level, depth);
            if (node.left != null) {
                stack.push(new NodeDepth(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new NodeDepth(node.right, depth + 1));
            }
        }

        return level;
    }
}

// BFS

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         int level = 0;
//         Queue<TreeNode> queue = new ArrayDeque<>();
//         queue.offer(root);
//         while (!queue.isEmpty()) {
            
//             int n = queue.size();

//             for (int i = 0; i < n; i++) {
//                 TreeNode previous_level_node = queue.remove();

//                 if (previous_level_node.left != null) {
//                     queue.offer(previous_level_node.left);
//                 }

//                 if (previous_level_node.right != null) {
//                     queue.offer(previous_level_node.right);
//                 }
//             }

//             level += 1;
//         }

//         return level;
//     }
// }

// Recursive DFS (Inorder)
// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree,
// O(n) if the tree is not balance

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         int maxLeft = maxDepth(root.left);
//         int maxRight = maxDepth(root.right);

//         return 1 + Integer.max(maxLeft, maxRight);
//     }
// }