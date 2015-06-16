public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        if(nums.length == 0) return result;
        check = new boolean[nums.length];
        generate(0, new ArrayList<Integer>());
        return result;
    }
    public void generate(int count, List<Integer> list) {
        if(count == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }else {
            for(int i = 0; i < nums.length; i++) {
                if(check[i]) continue;
                check[i] = true;
                list.add(nums[i]);
                generate(count + 1, list);
                list.remove(count);
                check[i] = false;
            }
        }
    }
}