public class Solution {
    private static int[][] kit = new int[][]{
            {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m == 0)  return;
        int n = board[0].length;
        int[][] record = new int[m][n];

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                for(int k = 0; k < 4; k++){
                    int tempx = i + kit[k][0];
                    int tempy = j + kit[k][1];
                    if(tempx < 0 || tempx >= m || tempy < 0 || tempy >= n)  continue;
                    if(board[tempx][tempy] == 1){
                        record[i][j]++;
                    }
                    if(board[i][j] == 1){
                        record[tempx][tempy]++;
                    }
                }
                if(record[i][j] < 2 || record[i][j] > 3)    board[i][j] = 0;
                else if(record[i][j] == 3)  board[i][j] = 1;
            }
        }
    }
}
