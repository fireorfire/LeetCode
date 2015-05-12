public class Solution {
    public int divide(int dividend, int divisor) {
        long result = divLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
    public long divLong(long dividend, long divisor) {
        
        boolean positive = !(dividend > 0 ^ divisor > 0);
        
        if(dividend < 0)dividend = - dividend;
        if(divisor < 0)divisor = -divisor;
        
        if(dividend < divisor) return 0;
        if(divisor == 0) return Integer.MAX_VALUE;
        
        long divided = 1;
        long num = divisor;
        while((num + num) < dividend) {
            num += num;
            divided += divided;
        }
        long result = divided + divLong(dividend - num, divisor);
        return positive ? result:-result;
    }
}