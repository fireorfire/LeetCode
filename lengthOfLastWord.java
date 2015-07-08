public class Solution {
    public int lengthOfLastWord(String s) {
        String[] sarr = s.split(" ");
        for(int i = sarr.length - 1; i >= 0; i--) {
            if(sarr[i].length() != 0) return sarr[i].length();
        }
        return 0;
    }
}