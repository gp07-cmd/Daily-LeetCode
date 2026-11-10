class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1 ; i <= n ; i++){
            int r = 1;
            int min = Integer.MAX_VALUE;
            while(  r < 4  && i>=r){
                min = Math.min(r * r + dp[i-r], min) ;
                

                r++;
            }
            dp[i] = costs[i-1] + min;

        }

        return dp[n];
    }
}