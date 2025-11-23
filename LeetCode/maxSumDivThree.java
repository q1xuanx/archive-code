class Solution {
    public int maxSumDivThree(int[] nums) {
        int [] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int x : nums) { 
            int [] prev = dp.clone();
            for (int r = 0; r < 3; r++) {
                int newR = (r + x % 3) % 3;
                dp[newR] = Math.max(dp[newR], prev[r] + x);
            }
        }
        return dp[0];
    }
}
