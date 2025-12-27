class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]); 
            return Long.compare(a[1], b[1]); 
        }); 

        for (int i =0; i < n; i++) free.add(i); 
        int [] cnt = new int[n]; 

        for (int[] meeting : meetings) { 
            int start = meeting[0], end = meeting[1]; 
            while (!busy.isEmpty() && busy.peek()[0] <= start) { 
                free.add((int)busy.poll()[1]);
            }

            if (!free.isEmpty()) { 
                int room = free.poll(); 
                cnt[room]++; 
                busy.add(new long[]{end, room}); 
            } else { 
                long[] earlies = busy.poll(); 
                long time = earlies[0], room = earlies[1]; 
                cnt[(int)room]++; 
                long dur = end - start; 
                busy.add(new long[]{time + dur, room}); 
            }
        }
        int best = 0; 
        for (int i = 1; i < n; i++) {
            if (cnt[i] > cnt[best]) {
                best = i; 
            }
        }
        return best; 
    }
}
