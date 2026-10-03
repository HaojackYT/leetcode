class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // s1 = "adc", s2 = "dcda"
        int n_s1 = s1.length(), n_s2 = s2.length();

        if (n_s1 > n_s2) {
            return false;
        }

        // s1_frequency[0] = 1
        // s1_frequency[3] = 1
        // s1_frequency[2] = 1
        int[] s1_frequency = new int[26];
        for (int i = 0; i < n_s1; i++) {
            int index = s1.charAt(i) - 'a';
            s1_frequency[index]++;
        }

        int start = 0, end = 0;
        for (int i = 0; i < n_s2; i++) {

            end = i;
            // 0 - 0 + 1 = 1 != 3
            // 1 - 0 + 1 = 2 != 3
            // 2 - 0 + 1 = 3 ("dcd") == 3

            // 2 - 1 + 1 = 2 != 3
            // 3 - 1 + 1 = 3 ("cda") == 3
            if (end - start + 1 == n_s1) {

                // "dcd"
                // s2_frequency[2] = 1
                // s2_frequency[3] = 2

                // "cda"
                // s2_frequency[2] = 1
                // s2_frequency[3] = 1
                // s2_frequency[0] = 1
                int[] s2_frequency = new int[26];
                for (int j = start; j <= end; j++) {
                    int index = s2.charAt(j) - 'a';
                    s2_frequency[index]++;
                }

                if (Arrays.equals(s1_frequency, s2_frequency)) {
                    return true;
                }

                start++;
            }
        }

        return false;
    }
}