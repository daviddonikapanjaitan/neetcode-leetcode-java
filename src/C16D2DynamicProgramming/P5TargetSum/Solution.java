package C16D2DynamicProgramming.P5TargetSum;

public class Solution {
    private int[][] dp;
    private int totalSum;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] inputs = new int[]{1, 1, 1, 1, 1};
        // int target = 3;

        int[] inputs = new int[]{1};
        int target = 1;

        int result = findTargetSumWay(inputs, target);
        System.out.println(result);
    }

    public int findTargetSumWay(int[] nums, int target) {
        totalSum = 0;
        for(int num: nums) totalSum += num;
        dp = new int[nums.length][2 * totalSum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if(i == nums.length) {
            return total ==target ? 1 : 0;
        }

        if(dp[i][total + totalSum] != Integer.MIN_VALUE){
            return dp[i][total + totalSum];
        }

        dp[i][total + totalSum] = backtrack(i + 1, total + nums[i], nums, target) +
                backtrack(i + 1, total - nums[i], nums, target);

        return dp[i][total + totalSum];
    }
}
