public class Solution {
    public void nextPermutation(int[] nums) {
        int up = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                up = i;
            }
        }
        if(up == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int nextHead;
        for(nextHead = up; nextHead < nums.length - 1; nextHead++) {
            if(nums[nextHead + 1] <= nums[up]) break;
        }
        int tem = nums[up];
        nums[up] = nums[nextHead];
        nums[nextHead] = tem;
        reverse(nums, up + 1, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start ++;
            end --;
        }
    }
}