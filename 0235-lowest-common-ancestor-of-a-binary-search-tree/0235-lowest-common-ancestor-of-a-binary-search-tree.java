/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) { // infinite loop until LCA is found
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            } else { // both cases return the LCA
                // if (current.val > p.val && current.val < q.val) ||
                // (current.val < p.val && current.val > q.val)
                // if (current.val == p.val || current.val == q.val)
                return current;
            }
        }

        return null;
    }
}