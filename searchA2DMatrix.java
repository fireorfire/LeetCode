public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        if(m == 0) return false;
        
        int start = 0, end = n - 1;
        while(start < end) {
            int mid = start + (end - start + 1) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) {
                end = mid - 1;
            }else {
                start = mid;
            }
        }
        
        int row = start;
        start = 0;
        end = m - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }
}