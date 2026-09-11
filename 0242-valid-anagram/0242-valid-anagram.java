class Solution {
    public boolean isAnagram(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        if (ns != nt) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < ns; i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < nt; i++) {
            char c = t.charAt(i);
            if (!hm.containsKey(c)) {
                return false;
            }
            int count = hm.get(c) - 1;
            if (count == 0) {
                hm.remove(c);
            } else {
                hm.put(c, count);
            }
        }

        return hm.isEmpty();
    }
}