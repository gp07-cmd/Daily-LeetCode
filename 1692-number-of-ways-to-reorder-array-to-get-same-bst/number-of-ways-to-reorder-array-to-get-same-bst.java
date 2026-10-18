class Solution {
    private static final long MOD = 1_000_000_007;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        combinations = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        
        return (int) ((getWays(list) - 1 + MOD) % MOD);
    }
    
    private long getWays(List<Integer> nums) {
        if (nums.size() <= 2) return 1;
        
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        
        long leftWays = getWays(left);
        long rightWays = getWays(right);
        
        long ways = combinations[left.size() + right.size()][left.size()];
        return (ways * leftWays % MOD) * rightWays % MOD;
    }
}