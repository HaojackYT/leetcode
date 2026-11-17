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
// Iterative BST Search
// Time Complexity: O(h)
// Space Complexity: O(1)

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }

        TreeNode current = root;

        while (true) {
            if (current.val < val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val, null, null);
                    break;
                }
            } else { // current.val > val
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val, null, null);
                    break;
                }
            }
        }

        return root;
    }
}

// Recursive DFS
// Time & Space Complexity: O(h)

// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         root = insertIntoBSTHelper(root, val);
//         return root;
//     }

//     public TreeNode insertIntoBSTHelper(TreeNode node, int val) {

//         if (node == null) {
//             node = new TreeNode(val, null, null);
//         } else if (val < node.val) {
//             node.left = insertIntoBSTHelper(node.left, val);
//         } else {
//             node.right = insertIntoBSTHelper(node.right, val);
//         }

//         return node;
//     }
// }