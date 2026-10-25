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
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            answer.add(node.val);

            // Based on FIFO (stack) so push right node first, then left node

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return answer;
    }
}

// Recursive

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();

//         preorder(root, answer);

//         return answer;
//     }

//     public void preorder(TreeNode node, List<Integer> answer) {
//         if (node == null) {
//             return;
//         }

//         answer.add(node.val);
//         preorder(node.left, answer);
//         preorder(node.right, answer);
//     }
// }