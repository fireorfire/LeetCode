public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        if(end < 0) return new int[]{-1, -1};
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) end = mid;
            else if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        if(nums[start] != target) return new int[]{-1, -1};
        int head = start;
        end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return new int[]{head, end};
    }
}