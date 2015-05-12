public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int count = 0;
        int len = -1;
        while(end < nums.length) {
            while(count < s && end < nums.length) {
                count += nums[end];
                end++;
            }
            int tem = count;
            while(count >= s && start < end) {
                count -= nums[start];
                start++;
            }
            if(tem >= s && (len == -1 || end - start + 1 < len)) {
                len = end - start + 1;
            }
        }
        return len == -1? 0: len;
    }
}