class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int row = -1;
        int row_left = 0, row_right = m - 1;
        while (row_left <= row_right) {

            int row_middle = (row_left + row_right) / 2;

            if (matrix[row_middle][0] <= target && target <= matrix[row_middle][n - 1]) {
                row = row_middle;
            }

            if (target < matrix[row_middle][0]) {
                row_right = row_middle - 1;
            } else {
                row_left = row_middle + 1;
            }
        }

        if (row < 0) {
            return false;
        }

        int left = 0, right = n - 1;
        while (right - left > 2) {

            int middle = (left + right) / 2;

            if (matrix[row][middle] == target) {
                return true;
            }  

            if (matrix[row][middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        for (int i = left; i <= right; i++) {
            if (matrix[row][i] == target) {
                return true;
            }
        }

        return false;
    }
}