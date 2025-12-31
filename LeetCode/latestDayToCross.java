// 1970. Last Day Where You Can Still Cross
// Keyword: Union Find
class Solution {

    class UnionFind {
        
        int [] root, size;

        public UnionFind(int n) { 
            root = new int[n]; 
            size = new int[n]; 
            for (int i = 0; i < n; i++) { 
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }

        int find(int x) { 
            if (root[x] != x) { 
                root[x] = find(root[x]);
            }
            return root[x];
        }

        void union(int x, int y) { 
            int rx = find(x); 
            int ry = find(y); 
            if (rx == ry) return; 
            if (size[rx] > size[ry]) { 
                int tmp = rx; 
                rx = ry; 
                ry = tmp; 
            }

            root[rx] = ry; 
            size[ry] += size[rx];
        }
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        UnionFind uf = new UnionFind(row * col + 2);
        int[][]grid = new int[row][col];
        int[][]dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int i = cells.length - 1; i >= 0; i--) { 
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;

            int i1 = r * col + c + 1; 

            for (int[]d : dir){ 
                int nr = r + d[0];
                int nc = c + d[1]; 
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) { 
                    uf.union(i1, nr * col + nc + 1);
                }
            }
            
            if (r == 0) uf.union(0, i1); 
            if (r == row - 1) uf.union(row * col + 1, i1); 
            if (uf.find(0) == uf.find(row * col + 1)) return i;
        }
        return -1;
    }
}
