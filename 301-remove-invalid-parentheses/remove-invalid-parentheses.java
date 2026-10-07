class Solution {
    Set<String> valid = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, new StringBuilder());

        int maxLen = 0;
        for (String str : valid) {
            maxLen = Math.max(maxLen, str.length());
        }

        List<String> ans = new ArrayList<>();
        for (String str : valid) {
            if (str.length() == maxLen) {
                ans.add(str);
            }
        }
        return ans;
    }

    void dfs(String s, int i, int balance, StringBuilder curr) {
        if (balance < 0) return;

        if (i == s.length()) {
            if (balance == 0) valid.add(curr.toString());
            return;
        }

        char ch = s.charAt(i);

        if (ch != '(' && ch != ')') {
            curr.append(ch);
            dfs(s, i + 1, balance, curr);
            curr.deleteCharAt(curr.length() - 1);
        } else {
            curr.append(ch);
            dfs(s, i + 1, ch == '(' ? balance + 1 : balance - 1, curr);
            curr.deleteCharAt(curr.length() - 1);
            dfs(s, i + 1, balance, curr);
        }
    }
}