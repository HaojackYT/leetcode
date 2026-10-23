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

    class TreeNodePair {
        TreeNode rootNode;
        TreeNode subNode;

        TreeNodePair(TreeNode rootNode, TreeNode subNode) {
            this.rootNode = rootNode;
            this.subNode = subNode;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        Stack<TreeNode> root_stack = new Stack<>();
        root_stack.push(root);

        while (!root_stack.isEmpty()) {
            TreeNode node_of_root = root_stack.pop();

            if (node_of_root.val == subRoot.val) {
                if (isSameTree(node_of_root, subRoot)) {
                    return true;
                }
            }

            if (node_of_root.left != null) {
                root_stack.push(node_of_root.left);
            }

            if (node_of_root.right != null) {
                root_stack.push(node_of_root.right);
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode rootNode, TreeNode subNode) {
        Stack<TreeNodePair> sub_stack = new Stack<>();
        sub_stack.push(new TreeNodePair(rootNode, subNode));

        while (!sub_stack.isEmpty()) {
            TreeNodePair pair = sub_stack.pop();

            TreeNode node_of_root = pair.rootNode;
            TreeNode node_of_sub = pair.subNode;

            if (node_of_root == null && node_of_sub == null) {
                continue; // matching
            }

            if (node_of_root == null || node_of_sub == null) {
                return false; // not matching
            }

            // The nodes' values must also match
            if (node_of_root.val != node_of_sub.val) {
                return false;
            }

            // Compare corresponding left children of both trees
            sub_stack.push(new TreeNodePair(node_of_root.left, node_of_sub.left));

            // Compare corresponding right children of both trees
            sub_stack.push(new TreeNodePair(node_of_root.right, node_of_sub.right));
        }

        return true;
    }
}
