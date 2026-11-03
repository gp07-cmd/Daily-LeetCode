class Solution {

    public int minMoves(int[] nums) {

        int max = 0, sum = 0;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }

            sum += num;
        }

        return nums.length * max - sum;
    }
}