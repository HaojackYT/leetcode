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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        postorder(root, answer);

        return answer;
    }

    public void postorder(TreeNode node, List<Integer> answer) {
        if (node == null) {
            return;
        }

        postorder(node.left, answer);
        postorder(node.right, answer);
        answer.add(node.val);
    }
}