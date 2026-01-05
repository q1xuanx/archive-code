class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totals = 0;
        int negative = 0, minNumber = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int num : row) {
                totals += Math.abs(num);
                negative += num < 0 ? 1 : 0;
                minNumber = Math.min(minNumber, Math.abs(num));
            }
        }

        if (negative % 2 == 1) {
            return totals - 2L * minNumber;
        }
        return totals;
    }
}
