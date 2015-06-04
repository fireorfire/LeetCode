public class Solution {
    public String addBinary(String a, String b) {
        char[] ach = a.toCharArray();
        char[] bch = b.toCharArray();
        
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int ai = ach.length - 1;
        int bi = bch.length - 1;
        int maxlen = Math.max(ai, bi);
        
        for(int i = maxlen; i >= 0; i--) {
            int result = carry;
            if(ai >= 0) result += (ach[ai] - '0');
            if(bi >= 0) result += (bch[bi] - '0');
            int bit = result % 2;
            carry = result / 2;
            sb.append((char)(bit + '0'));
            ai--;
            bi--;
        }
        if(carry != 0)
            sb.append((char)(carry + '0'));
        return sb.reverse().toString();
    }
}