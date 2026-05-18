import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, new ArrayList(), new boolean[nums.length]);
    }

    List<List<Integer>> dfs(int[] nums, List<Integer> curr, boolean[] visited) {
        List<List<Integer>> ans = new ArrayList();
        if(curr.size() == nums.length) {
            ans.add(new ArrayList(curr));
            return ans;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                ans.addAll(dfs(nums, curr, visited));
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
        return ans;
    }
}