class Solution {

    private int [][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

    public void go(int i, int j, int[][] sim) {
        int n = dirs.length, m = sim.length, p = sim[0].length;
        sim[i][j] = 3;
        for (int[]d : dirs) { 
            int x = i + d[0], y = j + d[1];
            while(x >= 0 && x < m && y >= 0 && y < p) {
                if (sim[x][y] == 2) {
                    break;
                }else {
                    sim[x][y] = 3;
                }
                x+= d[0];
                y+= d[1];
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] sim = new int[m][n];
        int res = 0;
        for (int [] i : walls) { 
            sim[i[0]][i[1]] = 2;
        }
        for (int [] i : guards) {
            sim[i[0]][i[1]] = 3;
        }
        // left -> right
        for (int i = 0; i < m; i++) {
            boolean guarded = false;
            for (int j = 0; j < n; j++) {
                if (sim[i][j] == 2) guarded = false;
                else if (sim[i][j] == 3) guarded = true;
                else if (guarded) sim[i][j] = 4;
            }
        }
        //right -> left
        for (int i = 0; i < m; i++) {
            boolean guarded = false;
            for (int j = n - 1; j >= 0; j--) {
                if (sim[i][j] == 2) guarded = false;
                else if (sim[i][j] == 3) guarded = true;
                else if (guarded) sim[i][j] = 4;
            }
        }
        // top -> bot
        for (int i = 0; i < n; i++) {
            boolean guarded = false;
            for (int j = 0; j < m; j++) {
                if (sim[j][i] == 2) guarded = false;
                else if (sim[j][i] == 3) guarded = true;
                else if (guarded) sim[j][i] = 4;
            }
        }

        // bot -> top
        for (int i = 0; i < n; i++) {
            boolean guarded = false;
            for (int j = m - 1; j >= 0; j--) {
                if (sim[j][i] == 2) guarded = false;
                else if (sim[j][i] == 3) guarded = true;
                else if (guarded) sim[j][i] = 4;
            }
        }

        for (int [] s : sim) {
            for (int i : s) {
                //System.out.print(i + " ");

                res += i == 0 ? 1 : 0;
            }
            //System.out.println();
                
        }
        return res;
    }
}
