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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        // root = [1,2,3,4,5,null,8,null,null,6,7,9]
        inorder(root, answer);

        return answer;
    }

    public void inorder(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }

        // inorder(1.left, answer) -> 2
        // inorder(2.left, answer) -> 4

        // inorder(4.left, answer) -> null
        // answer.add(4)
        // inorder(4.right, answer) -> null

        // answer.add(2)
        // inorder(2.right, answer) -> 5
        // inorder(5.left, answer) -> 6

        // inorder(6.left, answer) -> null
        // answer.add(6)

        // answer.add(5)
        // inorder(5.right, answer) -> 7

        // inorder(7.left, answer) -> null
        // answer.add(7)
        // inorder(7.right, answer) -> null

        // answer.add(1)
        // ...
        inorder(root.left, answer);
        answer.add(root.val);
        inorder(root.right, answer);
    }
}