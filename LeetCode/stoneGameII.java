class Solution {

    private int[] suff;
    private int[][] dp;

    public int dfs(int i, int M, int n) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][M] != -1) {
            return dp[i][M];
        }
        int ans = 0;
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {
            int nextI = i + X;
            int nextM = Math.max(M, X);
            int opp = dfs(nextI, nextM, n);
            int curr = suff[i] - opp;
            ans = Math.max(ans, curr);
        }
        return dp[i][M] = ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suff = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = piles[i] + suff[i + 1];
        }
        dp = new int[n][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return dfs(0, 1, n);
    }
}
// choose 1 2
