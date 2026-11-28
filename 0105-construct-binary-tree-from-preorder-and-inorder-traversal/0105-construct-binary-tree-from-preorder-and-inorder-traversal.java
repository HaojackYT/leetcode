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
// @opmiss
// Iterative DFS Inorder Construction
// Time & Space Complexity: O(n)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Contains the nodes whose left subtree has been constructed, but
        // the right subtree has not been constructed yet
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.MIN_VALUE, null, null);
        stack.push(root); // dummy root node

        int preorder_index = 0, inorder_index = 0;

        // The lastest node that has been pop() from `stack`
        // (its left subtree has been constructed)
        TreeNode node = null;
        TreeNode current = root;
        int n_inorder = inorder.length;
        while (inorder_index < n_inorder) {
            // Case 1: The current node is the left child of the lastest node
            // that has been pop() from `stack`
            if (stack.peek().val == inorder[inorder_index]) {
                node = stack.pop();
                inorder_index++;
            }
            // Case 2: Construct the right subtree of the lastest node that
            // has been pop() from `stack`
            else if (node != null) {
                current = new TreeNode(
                        preorder[preorder_index], null, null);
                node.right = current;
                node = null;
                stack.push(current);
                preorder_index++;
            }
            // Case 3: Construct left subtree of the current node
            else { // node == null
                current = new TreeNode(
                        preorder[preorder_index], null, null);
                stack.peek().left = current;
                stack.push(current);
                preorder_index++;
            }
        }

        return root.left;
    }
}

// Recursive DFS Preorder Construct
// Time Complexity: O(n^2)
// Search for each node's index in the inorder array O(n) x n nodes
// Space Complexity: O(n)

// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (preorder == null || inorder == null || preorder.length == 0 ||
//                 inorder.length == 0 || preorder.length != inorder.length) {

//             return null;
//         }
//         // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//         // [3,9,20,null,null,15,7]

//         // The 1st element in the preorder array is the root of the new tree
//         // preorder = [3|9,20,15,7]
//         TreeNode root = new TreeNode(preorder[0], null, null);

//         // The index of the root of the new tree in the inorder array is
//         // the partition point between the left and right subtrees
//         // inorder = [9|3|15,20,7]
//         int rootIndexInorder = 0;
//         for (int i = 0; i < inorder.length; i++) {
//             if (inorder[i] == root.val) {
//                 rootIndexInorder = i;
//                 break;
//             }
//         }

//         // The left subtree is from the elements in the preorder array that
//         // are to the right of the root and to the left of the partition point
//         // in the inorder array because of the length of [0, rootIndexInorder)
//         // in the inorder array = the length of [1, the 1st element in the
//         // right subtree of the tree] in the preorder array

//         // inorder = [9|3|15,20,7]
//         // [0, rootIndexInorder) = [9]
//         // preorder = [3|9,20,15,7]
//         // (1, the 1st element in the right subtree of the tree] = [9]
//         root.left = buildTree(Arrays.copyOfRange(
//                 preorder, 1, rootIndexInorder + 1),
//                 Arrays.copyOfRange(inorder, 0, rootIndexInorder));

//         root.right = buildTree(Arrays.copyOfRange(
//                 preorder, rootIndexInorder + 1, preorder.length),
//                 Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length));

//         return root;
//     }
// }