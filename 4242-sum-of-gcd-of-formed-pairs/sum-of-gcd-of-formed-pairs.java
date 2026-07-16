class Solution {
     public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {
        long max = -1;
        long[] pre = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max((long)nums[i], max);
            pre[i] = gcd((long)nums[i], max);
        }

        Arrays.sort(pre);
        
        int l = 0;
        int r = nums.length - 1;
        long ans = 0;

        while (r > l) 
            ans += gcd(pre[l++], pre[r--]);
        
        return ans;
    }
}