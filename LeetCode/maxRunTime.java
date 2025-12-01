// 2141. Maximum Running Time of N Computers
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long res = 0; 
        for (int i : batteries) res += i; 

        long left = 0, right = res / n; 
        while(left < right) {
            long md = (left + right + 1) >> 1;
            long need = md * n, have = 0; 

            for (int i : batteries) have += Math.min(i, md);

            if (have >= need) left = md; 
            else right = md - 1;
        }
        return left; 
    }
}
