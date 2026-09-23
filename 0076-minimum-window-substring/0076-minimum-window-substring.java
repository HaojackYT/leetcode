class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        if (m < n) {
            return "";
        }

        HashMap<Character, Integer> frequency_t = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            frequency_t.put(c, frequency_t.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> substring_s = new HashMap<>();

        int start = 0, end = 0, minStart = 0;
        // Current number of unique characters in the current window
        // that match the required frequency
        int formed = 0;
        int required = frequency_t.size();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);

            if (frequency_t.containsKey(c)) {
                substring_s.put(c, substring_s.getOrDefault(c, 0) + 1);

                if (substring_s.get(c).equals(frequency_t.get(c))) {
                    formed++;
                }
            }

            end++; // exclusive index

            // Try to shrink the current valid window
            while (formed == required) {

                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }

                char leftChar = s.charAt(start);

                if (frequency_t.containsKey(leftChar)) {
                    substring_s.put(leftChar, substring_s.get(leftChar) - 1);

                    if (substring_s.get(leftChar) < frequency_t.get(leftChar)) {
                        formed--;
                    }
                }

                start++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}