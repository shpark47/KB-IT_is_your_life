class Solution {
    int row;
    int col;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(grid[r][c] == '1' && !visited[r][c]) {
                    dfs(r, c, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(0 <= nr && nr < row && 0 <= nc && nc < col && grid[nr][nc] == '1') {
                if(!visited[nr][nc]) {
                    dfs(nr, nc, grid, visited);
                }
            }
        }
    }
}