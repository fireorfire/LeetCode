public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length - 1;
        for(int i = 0; i <= len;) {
            if(A[i] == elem) {
                A[i] = A[len];
                len--;
            }else {
                i++;
            }
        }
        return len + 1;
    }
}