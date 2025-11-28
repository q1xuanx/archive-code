// 2872 
// Key word: DFS, modulo
class Solution {

    private int ans;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i=0 ; i<n ; i++) {
            adj[i] = new ArrayList<>();
        }
        for (var e: edges) {
            int n0 = e[0], n1 = e[1];
            adj[n0].add(n1);
            adj[n1].add(n0);
        }

        ans = 0;

        dfs(values, k, adj, 0, -1);

        return ans;
    }

    private void dfs(int[] values, int k,
        List<Integer>[] adj, int node, int parent) {
        for (int child: adj[node]) {
            if (child != parent) {
                dfs(values, k, adj, child, node);

                values[node] += values[child];
                values[node] %= k;
            }
        }

        values[node] %= k;
        if (values[node] == 0) {
            ans++;
        }
    }
}
