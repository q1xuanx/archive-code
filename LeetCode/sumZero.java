class Solution {
    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }
        int [] res = new int[n];
        int decreseValue = n - (n * 2 - 1);
        int sum = 0, i = 0;
        while (decreseValue < 0) {
            res[i] = decreseValue;
            sum += Math.abs(decreseValue);
            decreseValue++; 
            i++;
        }
        res[i] = sum;
        return res;
    }
}
