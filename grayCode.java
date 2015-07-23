public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i = 0; i < n; i++) {
            int amount = (int)Math.pow(2, i);
            for(int j = amount - 1; j >= 0; j--) {
                result.add(result.get(j) + amount);
            }
        }
        return result;
    }
}