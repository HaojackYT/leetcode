class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!hm.contains(nums[i])) {
                hm.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}