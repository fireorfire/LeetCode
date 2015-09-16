public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length <= 0) return false;
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            if(nums[start] < nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) 
                    end = mid - 1;
                else
                    start = mid + 1;
            }else if(nums[mid] < nums[start]){
                if(nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else
                start = start + 1;
            
        }
        if(nums[start] == target) return true;
        return false;
    }
}