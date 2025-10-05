class Solution {
    private int m, n;
    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacifics = new boolean[m][n];
        boolean[][] atlantics = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacifics);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacifics);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantics);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantics);
        }
        List<List<Integer>> result = new ArrayList<>(); 
        for (int i=0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (pacifics[i][j] && atlantics[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if (heights[x][y] < heights[i][j])
                continue;
            dfs(x, y, heights, visited);
        }
    }
}
