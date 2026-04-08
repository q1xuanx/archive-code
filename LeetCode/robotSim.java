class Solution {
    int [][] dirs = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0, maxDist = 0;
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) { 
            obs.add(o[0] + "#" + o[1]);
        }
        for (int cmd : commands) {
            if (cmd == -2) { 
                dir = (dir + 3) % 4;
            } else if (cmd == -1) { 
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) { 
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (obs.contains(nx + "#" + ny)) break;
                    x = nx;
                    y = ny;
                    maxDist = Math.max((x * x) + (y * y), maxDist);
                }
            }
        }
        return maxDist;
    }
}