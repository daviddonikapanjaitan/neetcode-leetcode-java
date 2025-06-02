package C12D1DynamicProgramming.P3HouseRobber;

import java.util.Arrays;

public class Solution {
    private int[] memo;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] nums = new int[]{1, 2, 3, 1};
        // int result = rob(nums);

        int[] nums = new int[]{2, 7, 9, 3, 1};
        int result = rob(nums);

        System.out.println(result);
    }

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));

        return memo[i];
    }
}
