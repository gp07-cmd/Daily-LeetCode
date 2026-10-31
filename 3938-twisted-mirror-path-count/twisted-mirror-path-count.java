
class Solution {
    int m, n;
    int MOD = 1000000007;
    int[][][] dp;

    int solve(int[][] grid, int i, int j, int dir) {

        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        long ans = 0;

        if (grid[i][j] == 1) {

            if (dir == 1) {
                ans = solve(grid, i + 1, j, 2);
            }
            else if (dir == 2) {
                ans = solve(grid, i, j + 1, 1);
            }

        } else {

            int right = solve(grid, i, j + 1, 1);
            int down = solve(grid, i + 1, j, 2);

            ans = (right + (long) down) % MOD;
        }

        return dp[i][j][dir] = (int) ans;
    }

    public int uniquePaths(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, 0);
    }
}