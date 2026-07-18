class Solution {
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;
        for(int num : nums) {
            if(min > num) min = num;
            if(max < num) max = num;
        }
        return gcd(min, max);
    }
    
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}