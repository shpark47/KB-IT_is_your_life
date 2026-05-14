import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < n; i++) {
            graph.add(i, new ArrayList());
        }

        for(int[] e : edge) {
            int a = e[0] - 1;
            int b = e[1] - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        Queue<int[]> q = new ArrayDeque();
        int[] distince = new int[graph.size()];
        int node = 0;

        q.offer(new int[]{node, 0});
        visited[0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int next : graph.get(cur[0])) {
                if(!visited[next]) {
                    q.offer(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                    distince[next] = cur[1] + 1;
                }
            }
        }

        int answer = 0;
        int max = Arrays.stream(distince).max().getAsInt();
        for(int i : distince) {
            if(max == i) answer++;
        }

        return answer;
    }
}