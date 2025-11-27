// Problem 3381
// Key word is using prefix sum, and calculate by modulo of k 
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = Long.MIN_VALUE; 
        long [] pref = new long[n + 1];
        long [] bestMin = new long[k]; 
      
        for (int i = 0; i < n; i++) { 
            pref[i + 1] = pref[i] + nums[i]; 
        }

        Arrays.fill(bestMin, Long.MAX_VALUE);
        
        for (int i = 0; i <= n; i++) { 
            int group = i % k; 
            if (bestMin[group] != Long.MAX_VALUE) { 
                res = Math.max(res, pref[i] - bestMin[group]);
            }
            bestMin[group] = Math.min(bestMin[group], pref[i]);
        }

        return res;
    }
}
