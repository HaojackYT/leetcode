/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Recursion DFS Postorder Traversal
// Time & Space Complexity: O(n)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q);
    }

    public TreeNode lowestCommonAncestorHelper(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return null;
        }

        if (current.val > p.val && current.val > q.val) {
            return lowestCommonAncestorHelper(current.left, p, q);
        } else if (current.val < p.val && current.val < q.val) {
            return lowestCommonAncestorHelper(current.right, p, q);
        }

        return current;
    }
}

// Iterative BST Search
// Time Complexity: O(h)
// Space Complexity: O(1)

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNode current = root;

//         while (current != null) { // infinite loop until LCA is found
//             if (current.val > p.val && current.val > q.val) {
//                 current = current.left;
//             } else if (current.val < p.val && current.val < q.val) {
//                 current = current.right;
//             } else { // both cases return the LCA
//                 // if (current.val > p.val && current.val < q.val) ||
//                 // (current.val < p.val && current.val > q.val)
//                 // if (current.val == p.val || current.val == q.val)
//                 return current;
//             }
//         }

//         return null;
//     }
// }