public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        for(int i = n; i >= 0; i--) dp[i] = n - 1 - i;
        
        boolean[] palindrome = new boolean[n];
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 1; j >= i; j--) {
                if(i == j || (s.charAt(i) == s.charAt(j) && (i == j - 1 || palindrome[j - 1] == true))) {
                    palindrome[j] = true;
                    if(j == n -1 || (dp[j + 1] != -1 && dp[i] > dp[j + 1] + 1))
                        dp[i] = dp[j + 1] + 1;
                }else
                    palindrome[j] = false;
            }
        }
        return dp[0];
    }
}