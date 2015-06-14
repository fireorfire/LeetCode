public class Solution {
    public int mySqrt(int x) {
        long end = (long)(x / 2 + 1);
        long start = 0;
        while(start < end) {
            long mid = start + (end - start + 1) / 2;
            long mul = mid * mid;
            if(mul == (long)x) return (int)mid;
            if(mul > (long)x) end = mid - 1;
            else start = mid;
        }
        return (int)start;
    }
}