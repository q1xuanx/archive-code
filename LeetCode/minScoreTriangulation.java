class Solution {
    public int minScoreTriangulation(int[] values) {
        if (values.length == 3) {
            return values[0] * values[1] * values[2]; 
        }
        int n = values.length;
        int [][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int z = i + 1; z < j; z++) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j], dp[i][z] + values[i] * values[z] * values[j] + dp[z][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
