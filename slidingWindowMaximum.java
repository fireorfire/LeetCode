public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[0];
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++) {
            heap.offer(-nums[i]);
        }
        result[0] = -heap.peek();
        
        for(int i = k; i < n; i++) {
            heap.offer(-nums[i]);
            heap.remove(-nums[i - k]);
            result[i - k + 1] = -heap.peek();
        }
        
        return result;
    }
}