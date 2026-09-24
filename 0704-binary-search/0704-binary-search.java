class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0, right = n - 1;
        while (right - left > 2) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}