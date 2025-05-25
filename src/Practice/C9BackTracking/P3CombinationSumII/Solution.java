package Practice.C9BackTracking.P3CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        // int[] candidates = new int[]{10,1,2,7,6,1,5};
        // int target = 8;
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;

        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> cur, int total){
        if(total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(total > target || i == candidates.length) {
            return;
        }

        cur.add(candidates[i]);
        dfs(candidates, target, i + 1, cur, total + candidates[i]);
        cur.remove(cur.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        dfs(candidates, target, i + 1, cur, total);
    }
}
