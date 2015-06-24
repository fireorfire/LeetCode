public class Solution {
    public int minPathSum(int[][] grid) {
        int rlen = grid.length;
        if(rlen == 0) return 0;
        int clen = grid[0].length;
        if(clen == 0) return 0;
        
        for(int i = 1; i < rlen; i++) grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < clen; i++) grid[0][i] += grid[0][i - 1];
        
        for(int i = 1; i < rlen; i++) {
            for(int j = 1; j < clen; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[rlen - 1][clen - 1];
    }
}