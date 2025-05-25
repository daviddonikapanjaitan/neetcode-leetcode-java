package C9BackTracking.P5SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] nums = new int[]{1,2,2};
        // int[] nums = new int[]{0};

        List<List<Integer>> result = subsetWithDup(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> subsetWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backTrack(int i, List<Integer> subset, int[] nums) {
        res.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if(j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            backTrack(j + 1, subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
