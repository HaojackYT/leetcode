class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // @legendaryengineer
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            // "eat" -> ['e', 'a', 't'] -> ['a', 'e', 't'] -> "aet"
            // "tea" -> ['t', 'e', 'a'] -> ['a', 'e', 't'] -> "aet"
            Arrays.sort(charArr);
            // char[] to String
            String keyStr = String.valueOf(charArr);

            if (!hashMap.containsKey(keyStr))
                // "aet", ["eat", "tea", "ate"]
                hashMap.put(keyStr, new ArrayList<>());
            hashMap.get(keyStr).add(s);
        }
        
        return new ArrayList<>(hashMap.values());

        /*
        List<List<String>> answers = new ArrayList<>();
        int n_strs = strs.length;
        boolean[] visited = new boolean[n_strs];

        for (int i = 0; i < n_strs; i++) {
            // The current group of anagrams
            List<String> answer = new ArrayList<>();
            int n_str_1 = strs[i].length();

            // Check if the string has already been visited
            if (!visited[i]) {
                for (int j = i + 1; j < n_strs; j++) {
                    int n_str_2 = strs[j].length();

                    // Check if the two strings have the same length
                    if (n_str_1 == n_str_2) {

                        if (n_str_1 == 0) {
                            answer.add(strs[j]);
                            visited[j] = true;
                            continue;
                        }

                        // Character count of str_1
                        HashMap<Character, Integer> hashMap = new HashMap<>();

                        // Count the characters in str_1
                        for (int k = 0; k < n_str_1; k++) {
                            char c = strs[i].charAt(k);
                            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
                        }

                        // Count the characters in str_2
                        for (int k = 0; k < n_str_2; k++) {
                            char c = strs[j].charAt(k);

                            // Character not in str_1
                            if (!hashMap.containsKey(c)) {
                                break;
                            }

                            int count = hashMap.get(c) - 1;
                            if (count == 0) {
                                hashMap.remove(c);
                            } else {
                                hashMap.put(c, count);
                            }

                            if (hashMap.isEmpty()) {
                                answer.add(strs[j]);
                                visited[j] = true;
                            }
                        }
                    }
                }

                // Add str_1 to the current group of anagrams
                answer.add(strs[i]);
                visited[i] = true;
                answers.add(answer);
            }
        }

        return answers;
        */
    }
}