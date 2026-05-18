class Solution {
    int n, m;
    char[][] board;
    String word;
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;
        this.word = word;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(int i, int j, int idx) {
        if(idx == word.length()) {
            return true;
        }

        if(i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if(board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        for(int k = 0; k < 4; k++) {
            if(backtrack(i + dr[k], j + dc[k], idx + 1)) {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}