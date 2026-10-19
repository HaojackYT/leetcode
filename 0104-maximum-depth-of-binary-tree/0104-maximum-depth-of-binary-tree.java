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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode previous_level_node = queue.remove();

                if (previous_level_node.left != null) {
                    queue.offer(previous_level_node.left);
                }

                if (previous_level_node.right != null) {
                    queue.offer(previous_level_node.right);
                }
            }

            level += 1;
        }

        return level;
    }
}

// Recursive DFS
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