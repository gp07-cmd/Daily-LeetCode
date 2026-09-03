class Solution {
    public boolean uniformArray(int[] a) {
        int min = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int x : a) {
            min = Math.min(min, x);
            if (x % 2 == 1) oddCount++;
        }
        return min % 2 != 0 || oddCount == 0;
    }
}