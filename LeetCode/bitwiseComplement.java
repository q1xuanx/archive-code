class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int res = 0, index = 0;
        while (n > 0) {
            // res = (res << 1) 1001
            res |= (((n & 1) ^ 1) << index++);
            n >>= 1;
        }
        return res;
    }
}
