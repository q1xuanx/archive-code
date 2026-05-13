// LC: 1674

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[(limit * 2) + 2];
        for (int i = 0; i < n / 2; i++) { 
            int min = Math.min(nums[i], nums[n - i - 1]);
            int max = Math.max(nums[i], nums[n - i - 1]);
            
            delta[2]+=2;
            delta[min + 1]--;
            delta[min + max]--;
            delta[min + max + 1]++;
            delta[max + limit + 1]++;

            //System.out.println(delta[2] + " " + delta[min + 1] + " " + delta[min + max] + " " + delta[min + max + 1] + " " + delta[max + limit + 1]);
        }
        // System.out.println("===");
        int res = n, move = 0;
        for (int i = 2; i <= limit * 2; i++) {
            System.out.println(i + ": " + delta[i]);
            move += delta[i];
            //System.out.println(move + " " + res);
            res = Math.min(res, move);
        }
        return res;
    }
}
