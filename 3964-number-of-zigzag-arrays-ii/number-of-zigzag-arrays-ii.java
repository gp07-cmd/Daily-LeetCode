class Solution {
    static final int MOD = 1_000_000_007;

    int dot(int[] a, int[] b) {
        long sum = 0;
        for (int i = 0; i < a.length; i++)
            sum = (sum + (long) a[i] * b[i]) % MOD;
        return (int) sum;
    }

    void trans(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
    }

    int[][] mul(int[][] a, int[][] b) {
        int n = a.length;
        trans(b);
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = dot(a[i], b[j]);
        return c;
    }

    int[][] binexp(int[][] a, int p) {
        int n = a.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        while (p > 0) {
            if ((p & 1) == 1) res = mul(res, a);
            a = mul(a, a);
            p >>= 1;
        }
        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int[][] e = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = i + 1; j < m; j++)
                e[i][j] = 1;

        int[][] o = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                o[i][j] = e[m - 1 - i][m - 1 - j];

        int[][] conj = mul(e, o);
        int dist = n - 1;

        if (dist % 2 == 1) {
            conj = binexp(conj, dist / 2);
            conj = mul(conj, e);
        } else {
            conj = binexp(conj, dist / 2);
        }

        int[] base = new int[m];
        java.util.Arrays.fill(base, 1);
        long ans = 0;
        for (int[] row : conj)
            ans = (ans + dot(row, base)) % MOD;
        ans = (ans * 2) % MOD;
        return (int) ans;
    }
}