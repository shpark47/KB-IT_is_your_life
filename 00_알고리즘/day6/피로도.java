class Solution {
    int answer;
    boolean[] visited;
    int[][] dungeons;
    int n;
    public int solution(int k, int[][] dungeons) {
        this.n = dungeons.length;
        this.dungeons = dungeons;
        this.visited = new boolean[n];
        backtrack(k, 0);
        return answer;
    }

    void backtrack(int k, int count) {
        answer = Math.max(answer, count);
        for(int i = 0; i < n; i++) {
            int min = dungeons[i][0];
            int cost = dungeons[i][1];
            if(!visited[i] && k >= min) {
                visited[i] = true;
                backtrack(k - cost, count + 1);
                visited[i] = false;
            }
        }
    }
}