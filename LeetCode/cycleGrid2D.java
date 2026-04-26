class Solution {
    int[] dirX = new int[] { -1, 0, 1, 0 };
    int[] dirY = new int[] { 0, 1, 0, -1 };

    private boolean isValid(int x, int y, int n, int m) {
        return (x < n && x >= 0 && y < m && y >= 0);
    }

    private boolean isCycle(int x, int y, char[][] grid, boolean[][] visted, int parentX, int parentY) {
        visted[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int newX = x + dirX[k];
            int newY = y + dirY[k];
            if (isValid(newX, newY, grid.length, grid[0].length) && grid[newX][newY] == grid[x][y]
                    && !(parentX == newX && parentY == newY)) {
                if (visted[newX][newY])
                    return true;
                else {
                    boolean check = isCycle(newX, newY, grid, visted, x, y);
                    if (check)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visted = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visted[i], false);
        }
        boolean cycle = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visted[i][j]) {
                    cycle = isCycle(i, j, grid, visted, -1, -1);
                }
                if (cycle)
                    break;
            }
            if (cycle)
                return true;
        }
        return false;
    }

}