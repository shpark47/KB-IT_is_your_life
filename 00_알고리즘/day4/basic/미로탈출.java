import java.util.*;

class Solution {
    int n, m;
    int[] d = new int[2];
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    int[][] dis1, dis2;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int sr = 0, sc = 0, lr = 0, lc = 0, er = 0, ec = 0;
        char[][] grid = new char[n][m];
        for(int i = 0; i < maps.length; i++) {
            grid[i] = maps[i].toCharArray();
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] == 'L') {
                    lr = i;
                    lc = j;
                }
                if(grid[i][j] == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }
        dis1 = new int[n][m];
        dis2 = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dis1[i], -1);
            Arrays.fill(dis2[i], -1);
        }

        bfs(grid, sr, sc, lr, lc, dis1, 0);
        bfs(grid, lr, lc, er, ec, dis2, 1);

        if(d[0] == 0 || d[1] == 0) return -1;

        return d[0] + d[1];
    }

    void bfs(char[][] grid, int sr, int sc, int er, int ec, int[][] dis, int num) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{sr, sc});
        dis[sr][sc] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if(r == er && c == ec) d[num] = dis[r][c] - 1;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(grid[nr][nc] != 'X') {
                        if(dis[nr][nc] == -1) {
                            q.offer(new int[]{nr, nc});
                            dis[nr][nc] = dis[r][c] + 1;
                        }
                    }
                }
            }
        }
    }
}