import java.util.*;

class Solution {
    int n, m;
    int[][] distance;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int answer = -1;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        distance = new int[n][m];

        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }

        bfs(maps, 0, 0);

        return answer;
    }

    void bfs(int[][] maps, int sr, int sc) {
        int er = n - 1, ec = m - 1;

        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{sr, sc});
        distance[sr][sc] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.remove();
            int r = cur[0];
            int c = cur[1];

            if(r == er && c == ec) {
                answer = distance[r][c] + 1;
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(maps[nr][nc] == 1) {
                        if(distance[nr][nc] == -1) {
                            q.add(new int[]{nr, nc});
                            distance[nr][nc] = distance[r][c] + 1;
                        }
                    }
                }
            }
        }
    }
}