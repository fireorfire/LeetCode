public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>();
        HashMap<Character, Integer> match = new HashMap<>();
        int tlen = t.length(), slen = s.length();
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        
        for(char ch: tch) {
            if(hash.containsKey(ch)) {
                hash.put(ch, hash.get(ch) + 1);
            }
            else {
                match.put(ch, 0);
                hash.put(ch, 1);
            }
        }
        
        int start = 0, end = 0;
        int count = 0, mark = -1;
        int minimum = slen + 1;
        while(end < slen) {
            while(count < tlen) {
                if(end >= slen) break;
                if(match.containsKey(sch[end])) {
                    if(match.get(sch[end]) < hash.get(sch[end])) count++;
                    match.put(sch[end], match.get(sch[end]) + 1);
                }
                end++;
            }
            if(count < tlen) break;
            while(count >= tlen) {
                if(match.containsKey(sch[start])) {
                    match.put(sch[start], match.get(sch[start]) - 1);
                    if(hash.get(sch[start]) > match.get(sch[start])) {
                        count--;
                    }
                }
                start++;
            }
            int tem = end - start + 1;
            if(count == tlen - 1 && minimum > tem) {
                minimum = tem;
                mark = start - 1;
            }
        }
        if(mark == -1) return "";
        return s.substring(mark, minimum + mark);
    }
}