package Practice.C9BackTracking.P4Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] nums = new int[] {1, 2, 3};
        // List<List<Integer>> result = permute(nums);

        int[] nums = new int[] {0,1};
        List<List<Integer>> result = permute(nums);

        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backTrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backTrack(List<Integer> perm, int[] nums, boolean[] pick) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backTrack(perm, nums, pick);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
}
