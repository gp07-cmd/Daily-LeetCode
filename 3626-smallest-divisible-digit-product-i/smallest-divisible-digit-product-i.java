class Solution {
    public int smallestNumber(int n, int t) {
        int res = 0;
        while (true) {
            int ori = n, mul = 1;
            while (mul != 0 && ori > 0) {
                mul *= ori % 10;
                ori /= 10;
            }
            if (mul % t == 0) {
                res = n;
                break;
            }
            n++;
        }
        return res;
    }
}