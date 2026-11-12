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
// Recursion DFS Postorder Traversal
// Time & Space Complexity: O(n)

class Solution {

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        // root = [1,2,3,4,5]
        diameterOfBinaryTreeHelper(root);
        return this.diameter;
    }

    public int diameterOfBinaryTreeHelper(TreeNode node) {
        // node = [1]
        // node = [2]
        // node = [4]
        // node = [5]
        // node = [3]

        if (node == null) {
            return 0;
        }

        // node = [1], node.left = [2]
        // node = [2], node.left = [4]
        // node = [4], node.left = null

        // node = [5], node.left = null
        // node = [3], node.left = null
        int leftHeight = diameterOfBinaryTreeHelper(node.left);
        // node = [4], node.right = null

        // node = [2], node.right = [5]
        // node = [5], node.right = null
        // node = [1], node.right = [3]
        // node = [3], node.right = null
        int rightHeight = diameterOfBinaryTreeHelper(node.right);

        // Update the current largest diameter
        this.diameter = Math.max(this.diameter, leftHeight + rightHeight);

        // node = [4], leftHeight = 0, rightHeight = 0, diameter = 0
        // node = [5], leftHeight = 0, rightHeight = 0, diameter = 0
        // node = [2], leftHeight = 1, rightHeight = 1, diameter = 2
        // node = [3], leftHeight = 0, rightHeight = 0, diameter = 2
        // node = [1], leftHeight = 2, rightHeight = 1, diameter = 3
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// Iterative DFS Preorder Traversal
// Time & Space Complexity: O(n)

// class Solution {

//     class NodeState {
//         TreeNode node;
//         boolean visited;

//         NodeState(TreeNode node, boolean visited) {
//             this.node = node;
//             this.visited = visited;
//         }
//     }

//     public int diameterOfBinaryTree(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         Stack<NodeState> stack = new Stack<>();
//         Map<TreeNode, Integer> heights = new HashMap<>();
//         // root = [1,2,3,4,5]
//         stack.push(new NodeState(root, false));

//         int diameter = 0;
//         while (!stack.isEmpty()) {
//             // stack = [(root, false)]

//             NodeState item = stack.pop();
//             TreeNode node = item.node;

//             if (!item.visited) {
//                 // The current node's visited = false, so visit its children nodes first
//                 stack.push(new NodeState(node, true));

//                 if (node.right != null) {
//                     stack.push(new NodeState(node.right, false));
//                 }

//                 if (node.left != null) {
//                     stack.push(new NodeState(node.left, false));
//                 }

//                 // stack = [(root, true), (3, false), (2, false)]
//                 // stack = [(root, true), (3, false), (2, true), (5, false), (4, false)]
//             } else {
//                 // The heights of the children nodes of the current node's visited = true
//                 int leftHeight = heights.getOrDefault(node.left, 0);
//                 int rightHeight = heights.getOrDefault(node.right, 0);

//                 // Current longest diameter from the current node to its children nodes
//                 diameter = Math.max(diameter, leftHeight + rightHeight);

//                 // Height of the current node's visited = true in the tree
//                 heights.put(node, 1 + Math.max(leftHeight, rightHeight));
//             }
//         }

//         return diameter;
//     }
// }