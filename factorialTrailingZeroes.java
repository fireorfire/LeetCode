public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            int count5 = n / 5;
            count += count5;
            n = count5;
        }
        return count;
    }
}