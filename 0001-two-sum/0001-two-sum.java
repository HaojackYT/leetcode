class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[] {hashMap.get(complement), i};
            }
        }

        return new int[] {};

        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }

        // return new int[] {};
    }
}