class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length(); 
        int [] dp = new int[m]; 
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < i; j++) { 
                boolean ok = true; 
                for (int r = 0; r < n; r++) { 
                    if (strs[r].charAt(j) > strs[r].charAt(i)) { 
                        ok = false; 
                        break; 
                    }
                }
                if (ok) { 
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
        }

        int res = 0; 
        for (int i : dp) { 
            res = Math.max(res, i); 
        }
        return m - res - 1;
    }
}
