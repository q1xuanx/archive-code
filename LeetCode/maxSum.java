class Solution {
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length; 
        int [] prefix = new int[nums.length + 1];
        int [][] dp = new int [n + 1][k + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        for (int i = n - m + 1; i <= n; i++){
            Arrays.fill(dp[i], -100000000);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= k; i++) {
            int best = -100000000; 
            for (int j = n - m; j >= 0; j--) {
                int skip = dp[j + 1][i];
                best = Math.max(best, dp[j + m][i - 1] + prefix[j + m]);
                int start = -prefix[j];
                dp[j][i] = Math.max(skip, start + best);
            }
        }
        return dp[0][k];
    }
}
