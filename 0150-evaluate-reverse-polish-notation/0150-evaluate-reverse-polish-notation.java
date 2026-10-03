class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String tmp = tokens[i];

            if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();

                if (tmp.equals("+")) {
                    stack.push(first + second);
                } else if (tmp.equals("-")) {
                    stack.push(first - second);
                } else if (tmp.equals("*")) {
                    stack.push(first * second);
                } else {
                    stack.push(first / second);
                }
            } else {
                stack.push(Integer.parseInt(tmp));
            }
        }

        return stack.pop();
    }
}