public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        recSearch(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    public void recSearch(int[] nums, List<Integer> list, int start) {
        result.add(new ArrayList<Integer>(list));
        if(nums.length == start) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            recSearch(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
        return;
    }
}