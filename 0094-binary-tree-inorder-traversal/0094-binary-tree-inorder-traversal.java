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

    class NodeState {
        TreeNode node;
        boolean visited;

        NodeState(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, false));

        while (!stack.isEmpty()) {
            NodeState item = stack.pop();
            TreeNode node = item.node;

            if (!item.visited) {
                if (node.right != null) {
                    stack.push(new NodeState(node.right, false));
                }

                stack.push(new NodeState(node, true));

                if (node.left != null) {
                    stack.push(new NodeState(node.left, false));
                }
            } else {
                answer.add(node.val);
            }
        }

        return answer;
    }
}


// Recursion

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();

//         // root = [1,2,3,4,5,null,8,null,null,6,7,9]
//         inorder(root, answer);

//         return answer;
//     }

//     public void inorder(TreeNode root, List<Integer> answer) {
//         if (root == null) {
//             return;
//         }

//         // inorder(1.left, answer) -> 2
//         // inorder(2.left, answer) -> 4

//         // inorder(4.left, answer) -> null
//         // answer.add(4)
//         // inorder(4.right, answer) -> null

//         // answer.add(2)
//         // inorder(2.right, answer) -> 5
//         // inorder(5.left, answer) -> 6

//         // inorder(6.left, answer) -> null
//         // answer.add(6)

//         // answer.add(5)
//         // inorder(5.right, answer) -> 7

//         // inorder(7.left, answer) -> null
//         // answer.add(7)
//         // inorder(7.right, answer) -> null

//         // answer.add(1)
//         // ...
//         inorder(root.left, answer);
//         answer.add(root.val);
//         inorder(root.right, answer);
//     }
// }