class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int m = grid.length, n = grid[0].length; 
        int size = m * n;
        
        long[] pref = new long[size];
        long[] suff = new long[size];
        
        pref[0] = 1;
        for (int i = 1; i < size; i++) {
        	int r = (i - 1) / n, c = (i - 1) % n;
        	//System.out.println("Pref: " + r + " " + c);
        	pref[i] = (pref[i - 1] * grid[r][c]) % MOD;
        }
        
        suff[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
        	int r = (i + 1) / n, c = (i + 1) % n;
        	//System.out.println("Suff: " + r + " " + c);
        	suff[i] = (suff[i+1] * grid[r][c]) % MOD;
        }
        
        int[][]res = new int[m][n];
        for (int i = 0; i < size; i++) {
        	int r = i / n, c = i % n;
        	res[r][c] = (int) ((pref[i] * suff[i]) % MOD);
        }
    	return res;
    }
}
