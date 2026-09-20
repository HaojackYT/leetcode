class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        if (nums[0] == target) {
            return 0;
        }

        while (right - left > 2) {

            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // Left subarray is sorted
            if (nums[left] <= nums[middle]) {

                // Target is in the left sorted subarray
                if (nums[left] <= target && target <= nums[middle - 1]) {
                    if (nums[left] == target) {
                        return left;
                    }

                    if (nums[middle - 1] == target) {
                        return middle - 1;
                    }

                    right = middle - 1;

                } else { // Target is in the right subarray
                    left = middle + 1;
                }

            } else { // Right subarray is sorted

                // Target is in the right sorted subarray
                if (nums[middle + 1] <= target && target <= nums[right]) {
                    if (nums[right] == target) {
                        return right;
                    }

                    if (nums[middle + 1] == target) {
                        return middle + 1;
                    }

                    left = middle + 1;
                } else { // Target is in the left subarray
                    right = middle - 1;
                }
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