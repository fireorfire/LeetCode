public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int start = 0, end = len - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[end]) {
                if(nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }else {
                if(nums[start] <= target && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        if(nums[start] == target) return start;
        return -1;
    }
}