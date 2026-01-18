class Solution {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        
        int[][] rowsPref = new int[m][n];
        for (int i = 0; i < m; i++) { 
        	rowsPref[i][0] = grid[i][0];
        	for (int j = 1; j < n; j++) { 
        		rowsPref[i][j] = rowsPref[i][j-1] + grid[i][j];
        	}
        }
        int [][]colsPref = new int[m][n];
        for (int i = 0; i < n; i++) { 
        	colsPref[0][i] = grid[0][i];
        	for (int j = 1; j < m; j++) {
        		colsPref[j][i] = colsPref[j-1][i] + grid[j][i];
        	}
        }
        
        for (int side = Math.min(m, n); side >= 2; side--) { 
        	
        	for (int i = 0; i + side <= m; i++) { 
        		for (int j = 0; j + side <= n; j++) {
        			int rows = rowsPref[i][j+side-1] - (j > 0 ? rowsPref[i][j-1] : 0); 
        			boolean ok = true; 
        			for (int ii = i + 1; ii < i + side; ii++) {
        				if (rowsPref[ii][j + side - 1] - (j > 0 ? rowsPref[ii][j - 1] : 0) != rows) {
        					ok = false; 
        					break;
        				}
        			}
        			if (!ok) continue; 
        			
        			for (int jj = j; jj < j + side; jj++) { 
        				if (colsPref[i + side - 1][jj] - (i > 0 ? colsPref[i - 1][jj] : 0) !=rows) {
                            ok = false;
                            break;
        				}
        			}
        			if (!ok) continue; 
        			
        			int d1 = 0;
        			int d2 = 0; 
        			for (int k = 0; k < side; k++) { 
        				d1 += grid[i + k][j + k];
        				d2 += grid[i + k][j + side - 1 - k]; 
        			}
        			if (d1 == rows && d2 == rows) {
        				return side; 
        			}
        		}
        	}
        	
        }
        
        return 1;
    }
}
