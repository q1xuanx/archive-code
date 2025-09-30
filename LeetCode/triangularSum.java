class Solution {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length - 1, i = 0;
        while (nums[n] != -1 && i <= n -1) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
            // System.out.println(nums[i] + " ");
            i++;
            if (i == n) {
                nums[n] = -1;
                n--;
                i = 0;
            }
            // System.out.println("N: " + nums[n]);
        }
        return nums[0];
    }
}
