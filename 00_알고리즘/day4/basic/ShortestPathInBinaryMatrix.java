import java.util.*;

class Solution {
    int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];

        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{0, 0});
        distance[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if(r == n - 1 && c == m - 1) return distance[r][c];

            for(int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(grid[nr][nc] == 0) {
                        if(distance[nr][nc] == 0) {
                            q.offer(new int[]{nr, nc});
                            distance[nr][nc] = distance[r][c] + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}