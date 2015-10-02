public class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for(int i = 0; i <= r; i++) {
            if(nums[i] == 0) {
                if(i != l) {
                    nums[i] = nums[l];
                    nums[l] = 0;
                    l++;
                    i--;
                }
            }else if(nums[i] == 1) {
                continue;
            }else {
                if(i != r) {
                    nums[i] = nums[r];
                    nums[r] = 2;
                    r--;
                    i--;
                }
            }
        }
        return ;
    }
}