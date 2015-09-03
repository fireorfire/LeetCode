public class Solution {
    private int[][] matrix;
    private int m, n;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        return searchInRange(target, 0, m - 1, 0, n - 1);
    }
    public boolean searchInRange(int target, int r1, int r2, int c1, int c2) {
        if(r1 > r2 || c1 > c2) return false;
        int rm = r1 + (r2 - r1) / 2;
        int cm = c1 + (c2 - c1) / 2;
        if(matrix[rm][cm] == target) return true;
        else if(matrix[rm][cm] > target) {
            return searchInRange(target, r1, rm - 1, c1, cm - 1) || 
                searchInRange(target, rm, r2, c1, cm - 1) || 
                searchInRange(target, r1, rm - 1, cm, c2);
        } else {
            return searchInRange(target, rm + 1, r2, cm + 1, c2) ||  
                searchInRange(target, rm + 1, r2, c1, cm) || 
                searchInRange(target, r1, rm, cm + 1, c2);
        }
    }
}