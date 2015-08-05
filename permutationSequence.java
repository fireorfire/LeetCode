public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int denominator = 1;
        for(int i = 1; i <= n; i++) {
            list.add(i);
            denominator *= i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0; i--) {
            denominator /= i;
            int index = (k - 1) / denominator;
            sb.append(list.get(index));
            list.remove(index);
            k = (k - 1) % denominator + 1;
        }
        return sb.toString();
    }
}