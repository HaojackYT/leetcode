class MinStack {

    private int[] values;

    private int next;

    private int[] min_values;

    public MinStack() {
        values = new int[2];
        next = 0;
        min_values = new int[2];
    }

    public void push(int value) {
        adjust(1);
        values[next] = value;

        if (next == 0) {
            min_values[next] = value;
        } else {
            if (min_values[next - 1] > value) {
                min_values[next] = value;
            } else {
                min_values[next] = min_values[next - 1];
            }
        }

        next++;
    }

    public void pop() {
        next--;
    }

    public int top() {
        return values[next - 1];
    }

    public int getMin() {
        return min_values[next - 1];
    }

    private void adjust(int amount) {
        if (amount <= 0) {
            return;
        }

        // Check if there is enough space for the new elements
        if (next < values.length) {
            return;
        }

        // * 2: avoid frequent resizing
        int newSize = values.length * 2;

        values = Arrays.copyOf(values, newSize);
        min_values = Arrays.copyOf(min_values, newSize);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */