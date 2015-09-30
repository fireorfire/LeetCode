public class Solution {
    private List<List<String>> result = new ArrayList<>();
    private int n;
    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) return result;
        this.n = n;
        verifyQueens(new int[n], 0);
        return result;
    }
    public void verifyQueens(int[] list, int step) {
        if(step == n) {
            createBoard(list);
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
    public void createBoard(int[] list) {
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char[] ch = new char[n];
            Arrays.fill(ch, '.');
            ch[list[i]] = 'Q';
            board.add(new String(ch));
        }
        result.add(board);
        return;
    }
}