class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        if (n < 2) {
            return false;
        }

        if (s.charAt(n - 1) == '(' || s.charAt(n - 1) == '{' || s.charAt(n - 1) == '[') {
            return false;
        }

        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                
                if ((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') &&
                        stack.empty()) {
                            
                    return false;
                }

                if ((s.charAt(i) == ')' && stack.peek() == '(') ||
                        (s.charAt(i) == '}' && stack.peek() == '{') ||
                        (s.charAt(i) == ']' && stack.peek() == '[')) {

                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        }
        
        return false;
    }
}