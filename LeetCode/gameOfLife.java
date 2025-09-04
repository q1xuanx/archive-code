class Solution {

    public void gameOfLife(int[][] board) {
        int m = board.length; 
        int n = board[0].length; 
        
        int[][] liveBoard = new int [m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){ 
                int lives = countLive(board, i, j);
                liveBoard[i][j] = lives;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){ 
                if (board[i][j] == 1 && liveBoard[i][j] < 2) {
                    board[i][j] = 0;
                }else if (board[i][j] == 1 && liveBoard[i][j] >= 2 && liveBoard[i][j] <= 3) {
                    board[i][j] = 1;
                }else if (board[i][j] == 1 && liveBoard[i][j] > 3) {
                    board[i][j] = 0;
                }else if (board[i][j] == 0 && liveBoard[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    public int countLive(int[][] board, int x, int y) {
        List<List<Integer>> coordiantes = Arrays.asList(
            Arrays.asList(-1, -1),
            Arrays.asList(-1, 0),
            Arrays.asList(-1, 1),
            Arrays.asList(0, 1),
            Arrays.asList(1, 1),
            Arrays.asList(1, 0),
            Arrays.asList(1, -1),
            Arrays.asList(0, -1)
        );
        int lives = 0; 
        for (int i = 0; i < coordiantes.size(); i++) {
            int sampleX = x + coordiantes.get(i).get(0); 
            int sampleY = y + coordiantes.get(i).get(1);
            if(sampleX >= 0 && sampleY >= 0 && sampleX < board.length && sampleY < board[0].length && board[sampleX][sampleY] == 1) {
                lives++;
            } 
        }
        return lives;
    }
}
/*
    0 1 2 3 4 5 
0   1 1 1 1 1 1      
1   1 1 1 1 1 1
2   1 1 1 1 1 1
3   1 1 1 1 1 1  

coordinates = {-1,-1} {-1, 0} {-1, 1} {0,1} {1,1} {1,0} {1,-1} {0, -1}
*/
