public class Solution {
    public int jump(int[] nums) {
        int distance = 0, len = nums.length;
        int count = 0;
        for(int i = 0; i < len - 1; ) {
            int jump = nums[i] + i;
            if(jump >= len - 1) return count + 1;
            int max = jump;
            int index = i;
            for(int j = i + 1; j <= jump; j++) {
                int tem = j + nums[j];
                if(max < tem) {
                    max = tem;
                    index = j;
                }
            }
            if(max <= jump) return -1;
            count++;
            i = index;
        }
        return count;
    }
}