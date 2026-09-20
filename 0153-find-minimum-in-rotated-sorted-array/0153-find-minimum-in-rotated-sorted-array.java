class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        if (n == 1) {
            return nums[0];
        }

        // The array is not rotated ,so the first element is the minimum
        if (nums[left] < nums[left + 1] && nums[left] < nums[right]) {
            return nums[left];
        }

        while (right - left > 2) { // ensure the current subarray has at least 3 elements

            // The subarray is sorted, so the first element is the minimum
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int middle = (left + right) / 2;

            // The middle element is the minimum
            if (nums[middle] < nums[middle - 1] && nums[middle] < nums[middle + 1]) {
                return nums[middle];
            }

            // The left subarray is acending
            if (nums[middle] > nums[left]) {
                left = middle + 1; // The minimum is in the right subarray
            } else {
                right = middle - 1;
            }
        }

        // The current subarray has at most 2 elements
        int minValue = nums[left];

        for (int i = left + 1; i <= right; i++) {
            minValue = Math.min(minValue, nums[i]);
        }

        return minValue;

        // Arrays.sort(nums);
        // return nums[0];
    }
}