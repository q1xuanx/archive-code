class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        int l = 0, r = n - 1;
        int startPoint = 1;
        while (l <= r) {
            for (int i = l; i <= r; i++) {
                if (spiral[l][i] != 0) continue;
                spiral[l][i] = startPoint++;
            }
            for (int i = l+1; i < r; i++) {
                if (spiral[i][r] != 0) continue;
                spiral[i][r] = startPoint++;
            }
            for (int i = r; i >= l; i--) {
                if (spiral[r][i] != 0) continue;
                spiral[r][i] = startPoint++;
            }
            for (int i = r - 1; i > l; i--) {
                if (spiral[i][l] != 0) continue;
                spiral[i][l] = startPoint++;
            }
            l++;
            r--;
        }
        return spiral;
    }
}
