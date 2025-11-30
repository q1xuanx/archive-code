class Solution {
    public int minSubarray(int[] nums, int p) {
        int res = nums.length;
        long sum = 0;

        for (int i : nums) sum += i;
        int need = (int) (sum % p);
        if (need % p == 0) return 0;

        sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            
            sum = (sum + nums[i]) % p;
            int target = (int)((sum - need + p) % p);
            
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }

            map.put((int)sum, i);

        } 
        return nums.length == res ? -1 : res;
    }
}
