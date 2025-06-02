package Practice.C12D1DynamicProgramming.P4HouseRobberII;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] nums = new int[]{2, 3, 2};
        // int[] nums = new int[]{1, 2, 3, 1};
        // int[] nums = new int[]{1, 2, 3};
        int result = rob(nums);

        System.out.println(result);
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int helper(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}
