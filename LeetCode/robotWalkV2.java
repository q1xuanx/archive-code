class Robot {

    int[][] dirs = {
            {0, 1}, // North
            {1, 0}, // East
            {0, -1}, // South
            {-1, 0} // West
    };

    int boundX = 0, boundY = 0, x = 0, y = 0, dir = 1, cycle = 0;

    public Robot(int width, int height) {
        this.boundX = width - 1;
        this.boundY = height - 1;
        if (boundX == 0 || boundY == 0) {
            cycle = 2 * Math.max(boundX, boundY);
        } else {
            cycle = 2 * (boundX + boundY);
        }
    }

    public void step(int num) {
        
        num %= cycle;
        if (num == 0) { 
            num = cycle;
        }
        for (int i = 0; i < num; i++) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (nx < 0 || nx > boundX || ny < 0 || ny > boundY) {
                dir = (dir + 3) % 4;
                nx = x + dirs[dir][0];
                ny = y + dirs[dir][1];
            }
            x = nx;
            y = ny;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        switch (dir) {
            case 0 -> {
                return "North";
            }
            case 1 -> {
                return "East";
            }
            case 2 -> {
                return "South";
            }
            case 3 -> {
                return "West";
            }
            default -> {
                return "Null";
            }
        }
    }
}