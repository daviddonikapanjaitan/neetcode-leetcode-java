package Practice.C12D1DynamicProgramming.P8CoinChange;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] coins = new int[]{1, 2, 5};
        // int amount = 11;

        // int[] coins = new int[]{2};
        // int amount = 3;

        int[] coins = new int[]{1};
        int amount = 0;

        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
