class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];

        for (int x : arr) {
            count[Math.min(x, n)]++;
        }

        int val = 0;
        for (int i = 1; i <= n; i++) {
            val = Math.min(i, val + count[i]);
        }

        return val;
    }
}