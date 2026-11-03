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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // [3,9,20,null,null,15,7]

        // The 1st element in the preorder array is the root of the new tree
        // preorder = [3|9,20,15,7]
        TreeNode root = new TreeNode(preorder[0], null, null);
        
        // The index of the root of the new tree in the inorder array is
        // the partition point between the left and right subtrees
        // inorder = [9|3|15,20,7]
        int rootIndexInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndexInorder = i;
                break;
            }
        }

        // The left subtree is from the elements in the preorder array that are to the
        // right of the root and to the left of the partition point in the inorder array
        // because of the length of [0, rootIndexInorder) in the inorder array =
        // the length of [1, the 1st element in the right subtree of the tree]

        // in the preorder array
        // inorder = [9|3|15,20,7]
        // [0, rootIndexInorder) = [9]
        // preorder = [3|9,20,15,7]
        // [1, the 1st element in the right subtree of the tree) = [9]
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndexInorder + 1),
                Arrays.copyOfRange(inorder, 0, rootIndexInorder));

        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndexInorder + 1, preorder.length),
                Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length));

        return root;
    }
}