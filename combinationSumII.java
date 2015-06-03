public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates.length == 0) return result;
        this.candidates = candidates;
        generate(0, target, new ArrayList<Integer>());
        return result;
    }
    public void generate(int index, int target, List<Integer> list) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(list));
        }else {
            for(int i = index; i < candidates.length; i++) {
                if(i > index && candidates[i] == candidates[i - 1])continue;
                if(candidates[i] > target) break;
                list.add(candidates[i]);
                generate(i + 1, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}