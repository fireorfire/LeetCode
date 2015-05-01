public class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        for(int i = 0; i < n; i++) {
            prime[i] = true;
        }
        int result = 0;
        for(int i = 2; i < n; i++) {
            if(prime[i] == true) {
                int times = i + i;
                while(times < n) {
                    prime[times] = false;
                    times += i;
                }
                result++;
            }
        }
        return result;
    }
}