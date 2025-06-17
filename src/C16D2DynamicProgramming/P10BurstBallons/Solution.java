package C16D2DynamicProgramming.P10BurstBallons;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] nums = new int[]{3, 1, 5, 8};
        // int[] nums = new int[]{1, 5};

        int result = maxCoins(nums);
        System.out.println(result);
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                for (int i = l; i <= r; i++) {
                    int coins = newNums[l - 1] * newNums[i] * newNums[r + 1];
                    coins += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[1][n];
    }
}
