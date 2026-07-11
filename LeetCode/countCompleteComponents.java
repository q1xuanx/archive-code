class Solution {
    
    List<Integer>[] graph;
        
    int vertices;
    int edge;

    public void dfs(int curr, boolean[] visted) {
        visted[curr] = true;
        vertices++;
        for (int i = 0; i < graph[curr].size(); i++) {
            int v = graph[curr].get(i);
            edge++;
            if (!visted[v]) {
                dfs(v, visted);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        int ed = edges.length;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < ed; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visted = new boolean[n];
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            if (!visted[i]){
                edge = 0;
                vertices = 0;
                dfs(i, visted);
                edge /= 2;
                res += (edge == (vertices * (vertices - 1)) / 2) ? 1 : 0;
            }
            
        }
        return res; 
    }
}
