public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        int max = 0;
        for(int num: nums) {
            if(!set.contains(num)) continue;
            
            int count = 1;
            int left = num - 1;
            int right = num + 1;
            
            while(set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }
            
            while(set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }
            
            max = Math.max(count, max);
        }
        
        return max;
    }
}