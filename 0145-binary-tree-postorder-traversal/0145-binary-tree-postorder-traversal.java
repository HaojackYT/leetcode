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
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> preorder = new Stack<>();
        preorder.push(root);

        Stack<TreeNode> postorder = new Stack<>();
        while (!preorder.isEmpty()) {
            TreeNode node = preorder.pop();

            postorder.add(node);
            
            if (node.left != null) {
                preorder.push(node.left);
            }

            if (node.right != null) {
                preorder.push(node.right);
            }
        }

        while (!postorder.isEmpty()) {
            answer.add(postorder.pop().val);
        }

        return answer;
    }
}

// Recursive

// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();

//         postorder(root, answer);

//         return answer;
//     }

//     public void postorder(TreeNode node, List<Integer> answer) {
//         if (node == null) {
//             return;
//         }

//         postorder(node.left, answer);
//         postorder(node.right, answer);
//         answer.add(node.val);
//     }
// }