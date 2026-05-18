import java.util.*;

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        backtrack(0, nums, new ArrayList());
        return ans;
    }

    void backtrack(int idx, int[] nums, List<Integer> cur) {
        ans.add(new ArrayList(cur));
        for(int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, nums, cur);
            cur.remove(cur.size() - 1);
        }
    }
}