public class Solution {
    private int n, result;
    public int totalNQueens(int n) {
        this.n = n;
        verifyQueens(new int[n], 0);
        return result;
    }
    public void verifyQueens(int[] list, int step) {
        if(step == n) {
            result++;
        }else {
            for(int i = 0; i < n; i++) {
                int j = 0;
                for(;j < step; j++) {
                    if(i == list[j]) break;
                    if(Math.abs(j - step) == Math.abs(list[j] - i)) break;
                }
                if(j == step) {
                    list[step] = i;
                    verifyQueens(list, step + 1);
                }
            }
        }
    }
}