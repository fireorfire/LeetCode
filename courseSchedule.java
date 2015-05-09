public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> conn = new HashMap<>();
        int[] count = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            int[] tem = prerequisites[i];
            if(conn.containsKey(tem[1])) {
                List<Integer> list = conn.get(tem[1]);
                list.add(tem[0]);
            }else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(tem[0]);
                conn.put(tem[1], list);
            }
            count[tem[0]] ++;
        }
        
        int remain = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(count[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            remain--;
            if(conn.containsKey(x)) {
                List<Integer> list = conn.get(x);
                for(Integer next: list) {
                    count[next]--;
                    if(count[next] == 0) queue.add(next);
                }
            }
        }
        if(remain != 0) return false;
        return true;
        
    }
}