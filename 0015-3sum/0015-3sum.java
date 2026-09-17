class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        // [-1,0,1,2,-1,-4]
        // [-4,-1,-1,0,1,2]
        // Duplicate numbers will be adjacent to each other
        Arrays.sort(nums);
        int n = nums.length;
        // n - 2: triplets need at least 3 numbers
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate numbers of the 1st element in the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                long sum = (long) nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    answers.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate numbers of the 2nd element in the triplet
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate numbers of the 3rd element in the triplet
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Interate to the next pair
                    j++;
                    k--;

                } else if (sum < 0) {
                    // Need a larger number to raise the sum
                    j++;
                } else {
                    k--;
                }
            }
        }

        return answers;
    }
}