class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    result += r - l; // Cac cap tim duoc 
                    r--;
                }else l++;
            }
        }
        return result;
    }
}
