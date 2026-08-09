import java.util.*;

class Solution {
    int[] suffix;
    int[][] dp;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n];
        
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        dp = new int[n][n + 1];
        return dfs(0, 1);
    }

    private int dfs(int i, int M) {
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        if (dp[i][M] != 0) return dp[i][M];

        int result = 0;

        for (int X = 1; X <= 2 * M; X++) {
            int opponent = dfs(i + X, Math.max(M, X));
            result = Math.max(result, suffix[i] - opponent);
        }

        return dp[i][M] = result;
    }
}