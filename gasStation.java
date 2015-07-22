public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int recentPoint = -1, left = 0, count = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++) {
            count += gas[i];
            count -= cost[i];
            if(count < 0) {
                left += count;
                count = 0;
                recentPoint = i;
            }
        }
        if(count + left < 0) return -1;
        return recentPoint + 1;
    }
}