import java.util.*;
class Solution {
    int minDiff;
    public int solution(int n, int[][] wires) {
        minDiff = 100;
        // 간선리스트 -> 인접리스트
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }
        for(int[] e: wires){
            tree.get(e[0]-1).add(e[1]-1);
            tree.get(e[1]-1).add(e[0]-1);
        }
        // 노드의 개수 세는 dfs 코드
        dfs(0, tree, new boolean[n]);
        return minDiff;
    }
    // 노드의 개수 세는 dfs 코드 (그러면서, 차이값을 계산해서 업데이트)
    int dfs(int root, List<List<Integer>> tree, boolean[] visited){
        visited[root] = true;
        int count = 1;

        for(int child: tree.get(root)){
            if(!visited[child]){
                count += dfs(child, tree, visited);
            }
        }
        // 간선이 끊어졌다는 가정을 하고, 개수의 차이를 구함
        int cnt1 = tree.size() - count;
        int cnt2 = count;
        minDiff = Math.min(minDiff, Math.abs(cnt1 - cnt2));
        return count;
    }

}