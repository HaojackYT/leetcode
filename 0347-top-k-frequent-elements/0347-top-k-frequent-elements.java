class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answers = new int[k];

        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Count the frequency of each number
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        // b - a descending
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        // Get the top k frequent elements
        for (int i = 0; i < k; i++) {
            answers[i] = list.get(i).getKey();
        }

        return answers;
    }
}