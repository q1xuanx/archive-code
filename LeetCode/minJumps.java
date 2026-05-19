// LC 1345
// Use BFS
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) { 
            indexMap.computeIfAbsent(arr[i], (key) -> new ArrayList<>()).add(i);
            //indexMap.get(arr[i]).add(i);
        }   

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visted = new boolean[n];

        queue.add(new int[]{0,0});
        visted[0] = true;
        while (!queue.isEmpty()) { 
            int[] currentIndex = queue.poll();
            int node = currentIndex[0]; 
            int step = currentIndex[1];
            if (node == n - 1) {
                return step;
            }
            if (node - 1 >= 0 && !visted[node - 1]) {
                queue.add(new int[]{node - 1, step + 1});
                visted[node - 1] = true;
            }
            if (node + 1 < n && !visted[node + 1]) {
                queue.add(new int[]{node + 1, step + 1});
                visted[node + 1] = true;
            }
            for (Integer same : indexMap.get(arr[node])) {
                if (!visted[same]) { 
                    queue.add(new int[]{same, step + 1});
                    visted[same] = true;
                }
            }
            indexMap.get(arr[node]).clear();
        }
        return 1;
    }
}
