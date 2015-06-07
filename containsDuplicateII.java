public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])) {
                int prev = hash.get(nums[i]);
                if(i - prev <= k) return true;
            }
            hash.put(nums[i], i);
        }
        return false;
    }
}