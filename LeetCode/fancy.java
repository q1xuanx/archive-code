class Fancy {

    final int MOD = (int) 1e9 + 7;

    List<Long> fancyValue;

    int vAdd = 0, vMul = 1;

    public Fancy() {
        fancyValue = new ArrayList<>();
    }

    long modInverse(int x) {
        return pow(x, MOD - 2);

    }

    long pow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public void append(int val) {
        long x = (val - vAdd + MOD) % MOD;
        x = (x * modInverse(vMul)) % MOD;
        fancyValue.add(x);
    }

    public void addAll(int inc) {
        vAdd = (vAdd + inc) % MOD;
    }

    public void multAll(int m) {
        vMul = (int) ((long) vMul * m % MOD);
        vAdd = (int) ((long) vAdd * m % MOD);
    }

    public int getIndex(int idx) {
        if (idx >= fancyValue.size()) return -1;

        long val = fancyValue.get(idx);
        return (int)((val * vMul % MOD + vAdd) % MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
