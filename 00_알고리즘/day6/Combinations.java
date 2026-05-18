import java.util.*;

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList();
        dfs(1, n, k, new ArrayList());
        return ans;
    }

    void dfs(int start, int n, int k, List<Integer> cur) {
        if(cur.size() == k) {
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i = start; i <= n; i++) {
            cur.add(i);
            dfs(i + 1, n, k, cur);
            cur.remove(cur.size() - 1);
        }
    }
}