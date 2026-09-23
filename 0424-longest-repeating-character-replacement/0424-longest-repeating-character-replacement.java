class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int start = 0, end = 0, length = 0;

        int[] frequency = new int[26];
        int maxFrequency = 0;

        for (int i = 0; i < n; i++) {
            end = i;

            // Index of the current character in the frequency array
            int index = s.charAt(i) - 'A';
            frequency[index]++;

            maxFrequency = Math.max(maxFrequency, frequency[index]);

            int replaceTimes = (end - start + 1) - maxFrequency;

            while (replaceTimes > k) {
                // Index of the first character in the current window in the frequency array
                int startIndex = s.charAt(start) - 'A';

                frequency[startIndex]--;
                start++;

                replaceTimes = (end - start + 1) - maxFrequency;
            }

            if (length < end - start + 1) {
                length = end - start + 1;
            }
        }

        return length;
    }
}