class Solution {

    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    Set<String> seen = new HashSet<>();

    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length; 
        pq.offer(new int[]{grid[0][0], 0, 0});
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int maxD = curr[0], r = curr[1], c = curr[2];
            String key = r + "," + c;
            if (seen.contains(key)) continue;
            seen.add(key);
            if (r == m-1 && c == n - 1) return maxD; 
            for (int [] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen.contains(nr + "," + nc)) {
                    int newD = Math.max(maxD, grid[nr][nc]);
                    pq.offer(new int[]{newD, nr, nc});
                }
            }
        }
        return -1;
    }
}
