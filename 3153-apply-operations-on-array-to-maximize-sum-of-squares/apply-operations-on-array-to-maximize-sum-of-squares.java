class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[31];
        for (int i : nums) {
            int j = 0;
            while (i > 0) {
                bits[j] += (i % 2);
                i /= 2;
                j += 1;
            }            
        }
        int mod = 1000000007;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long a = 0;
            long c = 1;
            for (int j = 0; j < 31; j++) {
                if (bits[j] > 0) {
                    a += c;
                    bits[j] -= 1;
                }
                c *= 2;
            }
            a %= mod;
            ans = (ans + ((a * a) % mod)) % mod; 
        }
        return (int) ans;
    }
}