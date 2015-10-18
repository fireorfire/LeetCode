public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        for(int i = 0; i < (n + 1) / 2; i++) {
            for(int j = i; j < n - i - 1; j++) {
                result[i][j] = count;
                count ++;
            }
            for(int j = i; j < n - i - 1; j++) {
                result[j][n - i - 1] = count;
                count ++;
            }
            for(int j = i; j < n - i - 1; j++) {
                result[n - i - 1][n - j - 1] = count;
                count ++;
            }
            for(int j = i; j < n - i - 1; j++) {
                result[n - j - 1][i] = count;
                count ++;
            }
        }
        if(n % 2 == 1) result[n / 2][n / 2] = count;
        return result;
    }
}