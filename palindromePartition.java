public class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[][] dp;
    private String s;
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return result;
        
        createDP(s);
        this.s = s;
        
        searchPalindrome(0, new ArrayList<String>());
        return result;
    }
    public void createDP(String s) {
        int n = s.length();
        this.dp = new boolean[n][n];
        for(int len = 0; len < n; len++) {
            for(int i = 0; i < n - len; i++) {
                if(len == 0 || (s.charAt(i) == s.charAt(i + len) && (len == 1 || dp[i + 1][i + len - 1]))) {
                    dp[i][i + len] = true;
                }
            }
        }
    }
    public void searchPalindrome(int index, List<String> list) {
        if(index == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(dp[index][i]) {
                list.add(s.substring(index, i + 1));
                searchPalindrome(i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}