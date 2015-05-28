public class Solution {
    public String countAndSay(int n) {
        if(n < 1) return "";
        String s = "1";
        int count = 1;
        while(count < n) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int cnt = 1;
                int j;
                for(j = i + 1; j < s.length(); j++) {
                    if(s.charAt(j) != ch) {
                        break;
                    }
                    cnt++;
                }
                i = j - 1;
                sb.append(String.valueOf(cnt));
                sb.append(ch);
            }
            s = sb.toString();
            count++;
        }
        return s;
    }
}