public class Solution {
    int[][] matrix;
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if(row == 0) return;
        this.matrix = matrix;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row - i; j++) {
                swap(i, j, row - j - 1, row - i - 1);
            }
        }
        
        for(int i = 0; i < row / 2; i++) {
            for(int j = 0; j < row; j++) {
                swap(i, j, row - i - 1, j);
            }
        }
        return;
    }
    public void swap(int r1, int c1, int r2, int c2) {
        int tem = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tem;
    }
}