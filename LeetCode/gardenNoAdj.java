class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int [] path : paths) {
            graph[path[0] - 1].add(path[1] - 1);
            graph[path[1] - 1].add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean []used = new boolean[5];
            for (int node : graph[i]) {
                if (ans[node] != 0) {
                    used[ans[node]] = true;
                }
            }
            for (int c = 1; c <= 4; c++) {
                if (!used[c]) {
                    ans[i] = c;
                }
            }
        }
        return ans;
    }
}
