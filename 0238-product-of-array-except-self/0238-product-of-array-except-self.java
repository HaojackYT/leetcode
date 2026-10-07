class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // nums = [1,2,3,4]
        int[] answer = new int[n];
        // Calculate the product of all elements to the left of each index
        for (int i = 0, tmp = 1; i < n; i++) {

            // i = 0, tmp = 1, answer[0] = 1, tmp = tmp * nums[0] = 1 * 1 = 1
            // i = 1, tmp = 1, answer[1] = 1, tmp = tmp * nums[1] = 1 * 2 = 2
            // i = 2, tmp = 2, answer[2] = 2, tmp = tmp * nums[2] = 2 * 3 = 6
            // i = 3, tmp = 6, answer[3] = 6, tmp = tmp * nums[3] = 6 * 4 = 24
            answer[i] = tmp;
            tmp *= nums[i];
        }

        // Calculate the product of all elements to the right of each index
        for (int i = n - 1, tmp = 1; i >= 0; i--) {

            // i = 3, tmp = 1, answer[3] = 6 * 1 = 6, tmp = tmp * nums[3] = 1 * 4 = 4
            // i = 2, tmp = 4, answer[2] = 2 * 4 = 8, tmp = tmp * nums[2] = 4 * 3 = 12
            // i = 1, tmp = 12, answer[1] = 1 * 12 = 12, tmp = tmp * nums[1] = 12 *
            // i = 0, tmp = 24, answer[0] = 1 * 24 = 24, tmp = tmp * nums[0] = 24 * 1 = 24
            answer[i] *= tmp;
            tmp *= nums[i];
        }
        return answer;
    }
}