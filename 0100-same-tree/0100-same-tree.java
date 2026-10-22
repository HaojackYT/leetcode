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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pstack = new Stack<>();
        pstack.push(p);
        Stack<TreeNode> qstack = new Stack<>();
        qstack.push(q);

        while (!pstack.isEmpty() && !qstack.isEmpty()) {

            TreeNode current_pstack_node = pstack.pop();
            TreeNode current_qstack_node = qstack.pop();

            if (current_pstack_node == null && current_qstack_node == null) {
                continue;
            }

            if (current_pstack_node == null || current_qstack_node == null) {
                return false;
            }

            if (current_pstack_node.val != current_qstack_node.val) {
                return false;
            }

            pstack.push(current_pstack_node.left);
            pstack.push(current_pstack_node.right);

            qstack.push(current_qstack_node.left);
            qstack.push(current_qstack_node.right);
        }

        if (pstack.isEmpty() && qstack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}