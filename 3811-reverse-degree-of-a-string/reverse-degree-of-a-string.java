class Solution {
    public int reverseDegree(String s) {
        return IntStream.range(0, s.length()).map(i -> (123 - s.charAt(i)) * (i + 1)).sum();
    }
}