public class Solution {
    private char[][] board;
    private int n,m;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        if(n == 0) return false;
        this.m = board[0].length;
        if(m == 0) return false;
        this.board = board;
        char[] wch = word.toCharArray();
        
        if(wch.length > n * m) return false;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(searchWord(wch, 0, i, j))
                    return true;
            }
        }
        
        return false;
    }
    public boolean searchWord(char[] ch, int index, int r, int c) {
        if(index == ch.length) return true;
        if(r < 0 || r >= n || c < 0 || c >= m) return false;
        if(board[r][c] == ch[index]) {
            board[r][c] ^= 256;
            if( searchWord(ch, index + 1, r + 1, c) ||
                searchWord(ch, index + 1, r - 1, c) ||
                searchWord(ch, index + 1, r, c - 1) ||
                searchWord(ch, index + 1, r, c + 1))
                return true;
            board[r][c] ^= 256;
        }
        return false;
    }
}