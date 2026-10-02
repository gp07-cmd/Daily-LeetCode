class Solution {
    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> map = new HashMap<>();

        List<String> base = new ArrayList<>();
        base.add("");
        map.put(0, base);

        for (int i = 1; i <= n; i++) {
            List<String> curList = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                List<String> leftList = map.get(j);
                List<String> rightList = map.get(i - 1 - j);

                for (String left : leftList) {
                    for (String right : rightList) {
                        curList.add("(" + left + ")" + right);
                    }
                }
            }

            map.put(i, curList);
        }

        return map.get(n);
    }
}