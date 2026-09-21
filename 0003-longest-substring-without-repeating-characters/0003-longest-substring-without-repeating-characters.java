class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        int start = 0, end = 0, length = 1;
        boolean duplicate = false;
        for (int i = 1; i < n; i++) {

            for (int j = start; j <= end; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                end++;
            } else {
                // Move the start pointer to the right of the duplicate character
                for (int j = end; j >= start; j--) {
                    if (s.charAt(i) == s.charAt(j)) {
                        start = j + 1;
                        end = i;
                        break;
                    }
                }
                duplicate = false;
            }

            if (length < end - start + 1) {
                length = end - start + 1;
            }
        }

        return length;
    }
}