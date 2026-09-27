class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(new StringBuilder());
            } else if (ch == ')') {
                StringBuilder temp = stack.pop();
                temp.reverse();
                stack.peek().append(temp);
            } else {
                stack.peek().append(ch);
            }
        }

        return stack.peek().toString();
    }
}