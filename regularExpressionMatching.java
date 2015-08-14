public class Solution {
    public boolean isMatch(String s, String p) {
        int sn = s.length(), pn = p.length();
        char[] sch = s.toCharArray(), pch = p.toCharArray();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        dp[0][0] = true;
        
        for(int i = 0; i <= sn; i++) {
            for(int j = 1; j <= pn; j++) {
                if(pch[j - 1] != '*') {
                    if(i > 0 && dp[i - 1][j - 1] && (pch[j - 1] == '.' || pch[j - 1] == sch[i - 1]))
                        dp[i][j] = true;
                }else {
                    if(dp[i][j - 2] || i > 0 && dp[i - 1][j] && (pch[j - 2] == '.' || pch[j - 2] == sch[i - 1]))
                        dp[i][j] = true;
                }
            }
        }
        return dp[sn][pn];
    }
}