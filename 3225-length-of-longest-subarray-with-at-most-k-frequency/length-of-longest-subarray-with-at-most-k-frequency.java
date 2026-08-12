class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length, start = 0, end = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(end < n) {
            int temp = map.getOrDefault(nums[end], 0);
            if(temp < k) map.put(nums[end], temp + 1);
            else {
                maxLen = Math.max(end - start, maxLen);
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
                end--;
            }
            end++;
        }
        maxLen = Math.max(end - start, maxLen);
        return maxLen;
    }
}