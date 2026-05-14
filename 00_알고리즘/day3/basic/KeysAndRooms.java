import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque();
        int node = 0;

        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()) {
            int cur = q.remove();

            for(int next : rooms.get(cur)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        for(boolean b : visited) {
            if(!b) {
                return false;
            }
        }

        return true;
    }
}