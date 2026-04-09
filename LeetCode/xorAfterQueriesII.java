class Solution {

    final int MOD = 1_000_000_007;

    long modExp(long base, long exp) { 
        if (exp == 0) return 1;
        long half = modExp(base, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) result = (result * base) % MOD;
        return result;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int block = (int) Math.sqrt(n) + 1;
        List<int[]>[] buckets = new ArrayList[block];
        
        for (int i = 0; i < block; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (int[] query : queries) { 
            int left = query[0];
            int r = query[1];
            int k = query[2];
            int val = query[3];

            if (k < block) {
                buckets[k].add(query);
            } else {
                for (int pos = left; pos <= r; pos+= k) {
                    nums[pos] = (int)((1L * nums[pos] * val) % MOD);
                }
            }
        }

        for (int step = 1; step < block; step++) {
            if (buckets[step].isEmpty()) continue;
            long[] mul = new long[n + step + 2];
            Arrays.fill(mul, 1);
            for (int [] query : buckets[step]) { 
                int l = query[0];
                int r = query[1];
                int v = query[3];
                int lastIndex = l + ((r - l) / step) * step;
                int stop = lastIndex + step;
                mul[l] = (mul[l] * v) % MOD;
                long inv = modExp(v, MOD - 2);
                mul[stop] = (mul[stop] * inv) % MOD;
            }
            for (int i = 0; i < n; i++) {
                if (i - step >= 0) mul[i] = (mul[i] * mul[i - step]) % MOD;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = (int)((1L * nums[i] * mul[i]) % MOD);
            }
        }
        int res = 0;
        for (int i : nums) res ^= i;
        return res;
    }
}