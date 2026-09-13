class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> answers = new ArrayList<>();
        int n_strs = strs.length;
        boolean[] visited = new boolean[n_strs];

        for (int i = 0; i < n_strs; i++) {
            List<String> answer = new ArrayList<>();
            int n_str_1 = strs[i].length();

            if (!visited[i]) {
                for (int j = i + 1; j < n_strs; j++) {
                    int n_str_2 = strs[j].length();

                    if (n_str_1 == n_str_2) {

                        if (n_str_1 == 0) {
                            answer.add(strs[j]);
                            visited[j] = true;
                            continue;
                        }

                        HashMap<Character, Integer> hm = new HashMap<>();

                        for (int o = 0; o < n_str_1; o++) {

                            char c = strs[i].charAt(o);
                            hm.put(c, hm.getOrDefault(c, 0) + 1);
                        }

                        for (int o = 0; o < n_str_2; o++) {

                            char c = strs[j].charAt(o);
                            if (!hm.containsKey(c)) {
                                break;
                            }

                            int count = hm.get(c) - 1;
                            if (count == 0) {
                                hm.remove(c);
                            } else {
                                hm.put(c, count);
                            }

                            if (hm.isEmpty()) {
                                answer.add(strs[j]);
                                visited[j] = true;
                            }
                        }
                    }
                }

                answer.add(strs[i]);
                visited[i] = true;
                answers.add(answer);
            }
        }
        
        return answers;
    }
}