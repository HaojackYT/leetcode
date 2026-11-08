/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/
// Recursive
// Time Complexity: O(n^2 * log(n)), the slice method: O(n^2), recursion: O(log(n))
// Space Complexity: O(log(n))

class Solution {
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }

        Node root = new Node(true, false);
        root = constructHelper(root, grid);

        return root;
    }

    public Node constructHelper(Node node, int[][] grid) {

        int height = grid.length;
        int width = grid[0].length;

        // Base case (Step 1 + 2)

        // Step 1: Check whether all elements have the same value
        int firstValue = grid[0][0];
        boolean isSame = true;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] != firstValue) {
                    isSame = false;
                    break;
                }
            }

            if (!isSame) {
                break;
            }
        }

        // Step 2: If the region is uniform, create a leaf node
        if (isSame) {
            return new Node(firstValue == 1, true,
                    null, null,
                    null, null);
        }

        // Step 3: Divide the current grid into four sub-grids
        int midRow = height / 2;
        int midCol = width / 2;

        // Internal node
        node.val = true; // or false, it doesn't matter
        node.isLeaf = false;

        // Step 4: Recursively construct the four children
        node.topLeft = constructHelper(
                new Node(),
                slice(grid, 0, midRow, 0, midCol));
        node.topRight = constructHelper(
                new Node(),
                slice(grid, 0, midRow, midCol, width));
        node.bottomLeft = constructHelper(
                new Node(),
                slice(grid, midRow, height, 0, midCol));
        node.bottomRight = constructHelper(
                new Node(),
                slice(grid, midRow, height, midCol, width));

        return node;
    }

    public int[][] slice(int[][] src,
            int row_start, int row_end,
            int col_start, int col_end) {

        // Start and end indexes are exclusive
        int[][] result = new int[row_end - row_start][col_end - col_start];

        for (int row = row_start; row < row_end; row++) {
            System.arraycopy(
                    src[row],
                    col_start,
                    result[row - row_start],
                    0,
                    col_end - col_start);
        }

        return result;
    }
}