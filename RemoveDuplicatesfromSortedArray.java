public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length, curr = 0;
        if(len == 0) return 0;
        for(int i = 0; i < len; i++) {
            if(A[i] != A[curr]) {
                curr++;
                A[curr] = A[i];
            }
        }
        return curr + 1;
    }
}