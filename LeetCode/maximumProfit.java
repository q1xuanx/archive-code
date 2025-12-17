class Solution {
    class State {
        long maxProfit, buyHold, sellHold;

        State(long p, long b, long s) {
            maxProfit = p;
            buyHold = b;
            sellHold = s;
        }
    }

    public long maximumProfit(int[] prices, int k) {
        int firstPrice = prices[0];
        State[] dp = new State[k + 1];
        for (int idx = 0; idx <= k; idx++) {
            dp[idx] = new State(0, -firstPrice, firstPrice);
        }
        int n = prices.length;

        for (int day = 1; day < n; day++) {
            int currPrice = prices[day];
            for (int trans = k; trans > 0; trans--) {
                long prevProfit = dp[trans - 1].maxProfit;
                dp[trans].maxProfit = Math.max(dp[trans].maxProfit,
                        Math.max(dp[trans].buyHold + currPrice, dp[trans].sellHold - currPrice));
                dp[trans].buyHold = Math.max(dp[trans].buyHold, prevProfit - currPrice);
                dp[trans].sellHold = Math.max(dp[trans].sellHold, prevProfit + currPrice);
            }
        }

        return dp[k].maxProfit;
    }
}
