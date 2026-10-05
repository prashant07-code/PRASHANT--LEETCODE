class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int inner = stack.pop();
                int outer = stack.pop();

                stack.push(outer + Math.max(2 * inner, 1));
            }
        }

        return stack.pop();
    }
}