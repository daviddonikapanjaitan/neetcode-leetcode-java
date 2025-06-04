package Practice.C12D1DynamicProgramming.P11LongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    private int[] memo;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        // int[] nums = new int[]{0, 1, 0, 3, 2, 3};
        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        int result = lengthOfLIS(nums);

        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        int maxLIS = 1;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dfs(nums, i));
        }

        return maxLIS;
    }

    private int dfs(int[] nums, int i) {
        if(memo[i] != -1) {
            return memo[i];
        }

        int LIS = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if(nums[i] < nums[j]) {
                LIS = Math.max(LIS, 1 + dfs(nums, j));
            }
        }

        memo[i] = LIS;
        return LIS;
    }
}
