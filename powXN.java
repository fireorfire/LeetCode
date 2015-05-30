public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0) {
            n = -n;
            x = 1 / x;
        }
        double next = myPow(x, n / 2);
        if(n % 2 == 0) return next * next;
        return next * next * x;
    }
}