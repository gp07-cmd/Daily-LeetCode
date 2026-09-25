class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> words = new HashSet<>();
        expand(expression, words);

        List<String> answer = new ArrayList<>(words);
        Collections.sort(answer);
        return answer;
    }

    private void expand(String current, Set<String> words) {
        int close = current.indexOf('}');
        if (close == -1) {
            words.add(current);
            return;
        }

        int open = current.lastIndexOf('{', close);
        String prefix = current.substring(0, open);
        String suffix = current.substring(close + 1);

        String inside = current.substring(open + 1, close);
        for (String choice : inside.split(",")) {
            expand(prefix + choice + suffix, words);
        }
    }
}