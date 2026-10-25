import java.util.*;

class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int[][] vis = new int[n][m];
        int[] row = {0, 0, -1, 1};
        int[] col = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && vis[i][j] == 0) {
                    boolean b = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int r = p[0], c = p[1];

                        if (vis[r][c] == 1) continue;
                        vis[r][c] = 1;

                        for (int k = 0; k < 4; k++) {
                            int nr = r + row[k];
                            int nc = c + col[k];

                            if (nr >= 0 && nc >= 0 && nr < n && nc < m
                                && grid[nr][nc] == 1) continue;

                            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                                q.offer(new int[]{nr, nc});
                            } else {
                                b = false;
                            }
                        }
                    }

                    if (b) ans++;
                }
            }
        }

        return ans;
    }
}