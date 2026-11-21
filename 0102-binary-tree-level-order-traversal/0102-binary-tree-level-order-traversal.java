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
// Recursion DFS Preorder Traversal
// Time & Space Complexity: O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        levelOrderHelper(root, 1, answer);
        return answer;
    }

    public void levelOrderHelper(TreeNode node, int level, List<List<Integer>> answer) {
        if (node == null) {
            return;
        }

        // If the current level does not exist in `answer`
        if (answer.size() < level) {
            answer.add(new ArrayList<>());
        }

        answer.get(level - 1).add(node.val);
        levelOrderHelper(node.left, level + 1, answer);
        levelOrderHelper(node.right, level + 1, answer);
    }
}

// Iterative BFS Preorder Traversal
// Time & Space Complexity: O(n)

// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if (root == null) {
//             return new ArrayList<>();
//         }

//         List<List<Integer>> answer = new ArrayList<>();
//         Queue<TreeNode> queue = new ArrayDeque<>();
//         queue.offer(root);
//         while (!queue.isEmpty()) {

//             int n = queue.size();
//             List<Integer> level = new ArrayList<>();
//             for (int i = 0; i < n; i++) {
//                 TreeNode previous_level_node = queue.remove();

//                 level.add(previous_level_node.val);

//                 if (previous_level_node.left != null) {
//                     queue.offer(previous_level_node.left);
//                 }

//                 if (previous_level_node.right != null) {
//                     queue.offer(previous_level_node.right);
//                 }
//             }
//             if (level != null) {
//                 answer.add(level);
//             }
//         }

//         return answer;
//     }
// }