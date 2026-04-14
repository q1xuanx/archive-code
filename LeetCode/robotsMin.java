class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        List<Integer> slots = new ArrayList<>();
        for (int[] fac : factory) {
            for (int i = 0; i < fac[1]; i++) {
                slots.add(fac[0]);
            }
        }
        int n = robot.size();
        int m = slots.size();
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j-1];
                dp[i][j] = Math.min(dp[i-1][j-1] + Math.abs(robot.get(i - 1) - slots.get(j - 1)), dp[i][j]);
            }
        }
        return dp[n][m];
    }
}