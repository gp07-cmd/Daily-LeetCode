class Solution {
    private int m, n;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(grid, i, j);
                    if (sum % k == 0) count++;
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) return 0;

        long val = grid[r][c];
        grid[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            val += dfs(grid, r + dr[d], c + dc[d]);
        }
        return val;
    }
}