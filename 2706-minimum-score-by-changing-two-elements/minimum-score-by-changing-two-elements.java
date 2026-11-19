class Solution {
    public int minimizeSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = min;
        int thirdMin = secMin;
        int max = Integer.MIN_VALUE;
        int secMax = max;
        int thirdMax = secMax;
        for (int num : nums) {
            if (num > max) {
                thirdMax = secMax;
                secMax = max;
                max = num;
            } else if (num > secMax) {
                thirdMax = secMax;
                secMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }

            if (num < min) {
                thirdMin = secMin;
                secMin = min;
                min = num;
            } else if (num < secMin) {
                thirdMin = secMin;
                secMin = num;
            } else if (num < thirdMin) {
                thirdMin = num;
            }
        }
        int high1 = max - thirdMin;
        int high2 = thirdMax - min;
        int high3 = secMax - secMin;
        return Math.min(high1, Math.min(high2, high3));
    }
}