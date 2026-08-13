class Solution {
    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k = queryIndices.length;
        int n = s.length();

        char[] ch = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1, ch);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }

    public void build(int node, int left, int right, char[] ch) {
        if (left == right) {
            tree[node] = new Node(ch[left], ch[left], 1, 1, 1, 1);
            return;
        }

        int mid = left + (right - left) / 2;

        build(2 * node, left, mid, ch);
        build(2 * node + 1, mid + 1, right, ch);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public void update(int node, int left, int right, int idx, char newChar) {
        if (left == right) {
            tree[node] = new Node(newChar, newChar, 1, 1, 1, 1);
            return;
        }

        int mid = left + (right - left) / 2;

        if (idx <= mid) {
            update(2 * node, left, mid, idx, newChar);
        } else {
            update(2 * node + 1, mid + 1, right, idx, newChar);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public Node merge(Node left, Node right) {
        int prefixLen = left.prefixLen;
        int suffixLen = right.suffixLen;
        int maxLen = Math.max(left.maxLen, right.maxLen);

        if (left.lastChar == right.firstChar) {

            if (left.prefixLen == left.totalLen) {
                prefixLen = left.totalLen + right.prefixLen;
            }

            if (right.suffixLen == right.totalLen) {
                suffixLen = left.suffixLen + right.totalLen;
            }

            maxLen = Math.max(maxLen,
                    left.suffixLen + right.prefixLen);
        }

        return new Node(
                left.firstChar,
                right.lastChar,
                prefixLen,
                suffixLen,
                maxLen,
                left.totalLen + right.totalLen
        );
    }

    class Node {
        char firstChar;
        char lastChar;
        int prefixLen;
        int suffixLen;
        int maxLen;
        int totalLen;

        Node(char firstChar, char lastChar,
             int prefixLen, int suffixLen,
             int maxLen, int totalLen) {

            this.firstChar = firstChar;
            this.lastChar = lastChar;
            this.prefixLen = prefixLen;
            this.suffixLen = suffixLen;
            this.maxLen = maxLen;
            this.totalLen = totalLen;
        }
    }
}