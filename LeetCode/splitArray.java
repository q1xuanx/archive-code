class Solution {
    public long splitArray(int[] nums) {
        long [] pref = new long[nums.length + 1];
        pref[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            pref[i] = nums[i - 1] + pref[i - 1];
        }

        boolean[] incPrefix = new boolean[nums.length];
        incPrefix[0] = true;
        for (int i = 1; i < nums.length; i++) {
            incPrefix[i] = incPrefix[i - 1] && nums[i - 1] < nums[i];
        }

        boolean[] decSuffix = new boolean[nums.length];
        decSuffix[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            decSuffix[i] = decSuffix[i + 1] && nums[i] > nums[i + 1];
        }
        
        long result = Long.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!incPrefix[i] || !decSuffix[i + 1]) {
                continue;
            }
            long totalDiff = Math.abs(pref[i + 1] - (pref[nums.length] - pref[i + 1]));
            if (totalDiff < result) {
                result = totalDiff;
            }
        }
        return result == Long.MAX_VALUE ? -1 : result;
    }

}
