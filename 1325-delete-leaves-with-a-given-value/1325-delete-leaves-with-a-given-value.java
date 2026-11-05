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

// Interative DFS post-order traversal
// Time & Space Complexity: O(n)

class Solution {

    class NodeState {
        TreeNode node;
        boolean visited;

        NodeState(TreeNode node, boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, false));
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        while (!stack.isEmpty()) {
            NodeState item = stack.pop();
            TreeNode node = item.node;

            // The current node is a leaf node
            if (node.left == null && node.right == null) {

                if (node.val == target) {
                    TreeNode parent = parents.get(node); // of the current node

                    // Root node does not have a parent
                    if (parent == null) {
                        return null;
                    }

                    // Check if the current node is the left or right child of its parent
                    if (parent.left == node) {
                        parent.left = null;
                    } else if (parent.right == node) {
                        parent.right = null;
                    }
                }

            }
            // The current node is not a leaf node
            else {

                if (!item.visited) {
                    stack.push(new NodeState(node, true));

                    if (node.left != null) {
                        parents.put(node.left, node);
                        stack.push(new NodeState(node.left, false));
                    }

                    if (node.right != null) {
                        parents.put(node.right, node);
                        stack.push(new NodeState(node.right, false));
                    }
                }
            }
        }

        return root;
    }
}

// Recursive DFS post-order traversal
// Time & Space Complexity: O(n)

// class Solution {
//     public TreeNode removeLeafNodes(TreeNode root, int target) {
//         return removeLeafNodesHelper(root, target);
//     }

//     public TreeNode removeLeafNodesHelper(TreeNode node, int target) {
//         if (node == null) {
//             return null;
//         }

//         node.left = removeLeafNodesHelper(node.left, target);
//         node.right = removeLeafNodesHelper(node.right, target);

//         if (node.left == null && node.right == null && node.val == target) {
//             return null;
//         } else {
//             return node;
//         }
//     }
// }