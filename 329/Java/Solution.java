/*
    own solution -- easy to think.
 */
public class Solution {
    private int search(int[][] matrix,int[][] map, int i, int j){
        if(map[i][j] != 0){
            return map[i][j];
        }
        if(i + 1 < map.length && matrix[i][j] > matrix[i+1][j] && map[i][j] < 1 + search(matrix ,map, i+1, j)){
            map[i][j] = 1 + map[i+1][j];
        }
        if(i - 1 > -1 && matrix[i][j] > matrix[i-1][j] && map[i][j] < 1 + search(matrix, map, i-1, j)){
            map[i][j] = 1 + map[i-1][j];
        }
        if(j - 1 > -1 &&  matrix[i][j] > matrix[i][j-1] && map[i][j] < 1 + search(matrix,map, i, j-1)){
            map[i][j] = 1 + map[i][j-1];
        }
        if(j + 1 < map[0].length && matrix[i][j] > matrix[i][j+1]  && map[i][j] < 1 + search(matrix, map, i, j+1)){
            map[i][j] = 1 + map[i][j+1];
        }

        map[i][j] = (map[i][j] == 0) ? 1 : map[i][j];

        return map[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[][] map = new int[matrix.length][matrix[0].length];
        int re = 0, i = 0, j = 0, temp = 0;

        while(true) {
            while (map[i][j] != 0) {
                if (i == map.length - 1 && j == map[0].length - 1) {
                    return re;
                }
                if (j == map[0].length - 1) {
                    i++;
                    j = 0;
                } else {
                    j++;
                }
            }
            temp = search(matrix, map, i, j);
            re = re > temp ? re : temp;
        }
    }
}
