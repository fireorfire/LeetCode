public class Solution {
    public int minDistance(String word1, String word2) {
        int r = word1.length() + 1, c = word2.length() + 1;
        int[][] opt = new int[r][c];
        for(int i = 0; i < c; i++) opt[0][i] = i;
        for(int i = 0; i < r; i++) opt[i][0] = i;
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) opt[i][j] = opt[i - 1][j - 1];
                else {
                    int tem = Math.min(Math.min(opt[i][j - 1], opt[i - 1][j]), opt[i - 1][j - 1]);
                    opt[i][j] = tem + 1;
                }
            }
        }
        return opt[r - 1][c - 1];
    }
}