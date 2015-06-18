public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int first = (C - A) * (D - B);
        int second = (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        if(left >= right || top <= bottom) return first + second;
        return first + second - (right - left) * (top - bottom);
    }
}