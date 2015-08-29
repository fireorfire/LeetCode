public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        if(n == 0) return true;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int i = 0; i < n; i++) {
            if(!dp[i]) continue;
            for(int j = i; j < n; j++) {
                if(dp[j + 1]) continue;
                String tem = s.substring(i, j + 1);
                if(wordDict.contains(tem)) dp[j + 1] = true;
            }
        }
        
        return dp[n];
    }
}