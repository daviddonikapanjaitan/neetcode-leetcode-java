package Practice.C9BackTracking.P2CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<Integer>> res;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] candidates = new int[]{2,3,6,7};
        // int target = 7;

        int[] candidates = new int[]{2,3,5};
        int target = 8;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
}
