public class Solution {
    public String shortestPalindrome(String s) {
        if(s.equals("")) return s;
        int len = s.length();
        int mid = len / 2;
        for(; mid > 0; mid--) {
            String result;
            result = checkForPalindrome(s, mid, mid);
            if(result != null) return result;
            if(s.charAt(mid) == s.charAt(mid - 1)) {
                result = checkForPalindrome(s, mid - 1, mid);
                if(result != null) return result;
            }
        }
        return checkForPalindrome(s, 0, 0);
    }
    public String checkForPalindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length()) {
            if(s.charAt(l) != s.charAt(r)) break;
            l--;
            r++;
        }
        
        if(l >= 0) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder(s);
        for(int i = r; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }
}