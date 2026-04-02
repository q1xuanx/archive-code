class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int [][][] dp = new int[m][n][3];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) { 
        		for (int k = 0; k < 3; k++) dp[i][j][k] = Integer.MIN_VALUE;
        	}
        }
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) { 
        	dp[0][0][1] = 0;
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) { 
        		if (i == 0 && j == 0) continue;
        		for (int k = 0; k < 3; k++) {
        			int best = Integer.MIN_VALUE;
        			if (i > 0 && dp[i-1][j][k] != Integer.MIN_VALUE) { 
        				best = Math.max(dp[i-1][j][k], best);
        			}
        			if (j > 0 && dp[i][j-1][k] != Integer.MIN_VALUE) { 
        				best = Math.max(dp[i][j-1][k], best);
        			}
        			if (coins[i][j] > 0) { 
        				if (best != Integer.MIN_VALUE) { 
        					dp[i][j][k] = Math.max(dp[i][j][k], best + coins[i][j]);
        				}
        			} else {
        				if (best != Integer.MIN_VALUE) { 
        					dp[i][j][k] = Math.max(dp[i][j][k], best + coins[i][j]);
        				}
        				if (k > 0) { 
        					int bestNeutral = Integer.MIN_VALUE; 
        					if (i > 0 && dp[i-1][j][k-1] != Integer.MIN_VALUE) { 
        						bestNeutral = Math.max(dp[i-1][j][k-1], bestNeutral);
        					}
        					if (j > 0 && dp[i][j-1][k-1] != Integer.MIN_VALUE) { 
        						bestNeutral = Math.max(dp[i][j-1][k-1], bestNeutral);
        					}
        					if (bestNeutral != Integer.MIN_VALUE) {
        						dp[i][j][k] = Math.max(dp[i][j][k], bestNeutral);
        					}
        				}
        			}
        		}
        	}
        }
        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}
