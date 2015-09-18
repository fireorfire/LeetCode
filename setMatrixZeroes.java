public class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rlen = matrix.length;
        if(rlen == 0) return;
        int clen = matrix[0].length;
        if(clen == 0) return;
        
        boolean rowZero = false, colZero = false;
        
        for(int i = 0; i < rlen; i++) {
            if(matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        for(int i = 0; i < clen; i++) {
            if(matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }
        
        for(int i = 1; i < rlen; i++) {
            for(int j = 1; j < clen; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < rlen; i++) {
            if(matrix[i][0] == 0) zeroize(matrix, 0, i);
        }
        for(int i = 1; i < clen; i++) {
            if(matrix[0][i] == 0) zeroize(matrix, 1, i);
        }
        
        if(rowZero) zeroize(matrix, 0, 0);
        if(colZero) zeroize(matrix, 1, 0);
        
    }
    public void zeroize(int[][] matrix, int rc, int index) {
        if(rc == 0) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[index][i] = 0;
            }
        }else {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][index] = 0;
            }
        }
    }
}