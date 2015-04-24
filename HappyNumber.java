public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hash = new HashSet<>();
        while(true) {
            if(hash.contains(n)) break;
            hash.add(n);
            int next = 0;
            while(n != 0) {
                int digit = n%10;
                next += Math.pow(digit, 2);
                n /= 10;
            }
            if(next == 1) return true;
            n = next;
        }
        return false;
    }
}