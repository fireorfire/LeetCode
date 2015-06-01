public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9]; 
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int index = board[i][j] - '1';
                if(check[index]) return false;
                check[index] = true;
            }
        }
        for(int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9]; 
            for(int j = 0; j < 9; j++) {
                if(board[j][i] == '.') continue;
                int index = board[j][i] - '1';
                if(check[index]) return false;
                check[index] = true;
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!checkBlock(board, i*3, j*3)) return false;
            }
        }
        return true;
    }
    public boolean checkBlock(char[][] board, int row, int column) {
        boolean[] check = new boolean[9];
        for(int i = row; i < row + 3; i++) {
            for(int j = column; j < column + 3; j++) {
                if(board[i][j] == '.') continue;
                int index = board[i][j] - '1';
                if(check[index]) return false;
                check[index] = true;
            }
        }
        return true;
    }
}