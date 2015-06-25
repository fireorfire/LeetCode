public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rlen = matrix.length;
        if(rlen == 0) return 0;
        int clen = matrix[0].length;
        if(clen == 0) return 0;
        
        int[][] row = new int[rlen + 1][clen + 1];
        int[][] col = new int[rlen + 1][clen + 1];
        int[][] opt = new int[rlen + 1][clen + 1];
        int max = 0;
        
        for(int i = 1; i <= rlen; i++) {
            for(int j = 1; j <= clen; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    row[i][j] = row[i][j - 1] + 1;
                    col[i][j] = col[i - 1][j] + 1;
                    opt[i][j] = Math.min(opt[i - 1][j - 1] + 1, Math.min(row[i][j], col[i][j]));
                    if(opt[i][j] > max) max = opt[i][j];
                }
            }
        }
        
        return max * max;
        
        // row[0][0] = (matrix[0][0] == '1')? 1: 0;
        // col[0][0] = (matrix[0][0] == '1')? 1: 0;
        // opt[0][0] = (matrix[0][0] == '1')? 1: 0;
        // for(int i = 1; i < clen; i++) {
        //     col[0][i] = (matrix[0][i] == '1')? 1: 0;
        //     if(row[0][i] == '1')row[0][i] = row[0][i - 1];
        //     opt[0][i] = col[0][i];
        // }
    }
}