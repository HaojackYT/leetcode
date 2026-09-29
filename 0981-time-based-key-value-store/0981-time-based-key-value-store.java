class TimeMap {

    private static class Node {
        String value;
        int timestamp;

        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Node>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if (!hashMap.containsKey(key)) {
            return "";
        }

        List<Node> nodes = hashMap.get(key);
        int n = nodes.size();

        if (n == 1) {
            if (nodes.get(0).getTimestamp() <= timestamp) {
                return nodes.get(0).getValue();
            }

            return "";
        }

        int left = 0, right = n - 1;
        int largest = -1;
        while (left <= right) {

            int middle = (left + right) / 2;

            int middle_timestamp = nodes.get(middle).getTimestamp();

            if (middle_timestamp <= timestamp) {
                largest = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (largest == -1) {
            return "";
        }

        return nodes.get(largest).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */