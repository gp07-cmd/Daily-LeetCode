class Solution {
    // Every 2-element subarray satisfies prod == lcm * gcd.
    private static final int MIN_VALID_SUBARR_LEN = 2;

    // Subarrays of length >= 3 are valid iff elements are pairwise coprime.
    private static boolean isCoprime(int num1, int num2) {
        while (num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return num1 == 1;
    }

    public int maxLength(int[] nums) {

        int startIdx = 0;
        int maxSubarrLen = MIN_VALID_SUBARR_LEN;
        int subarrProd = 1;

        for (int endIdx = 0; endIdx < nums.length; ++endIdx) {
            int currNum = nums[endIdx];


            while (!isCoprime(subarrProd, currNum)) {
                subarrProd /= nums[startIdx];
                ++startIdx;
            }

            int currSubarrLen = endIdx - startIdx + 1;

            maxSubarrLen = Math.max(maxSubarrLen, currSubarrLen);
            subarrProd *= currNum;
        }

        return maxSubarrLen;
    }
}