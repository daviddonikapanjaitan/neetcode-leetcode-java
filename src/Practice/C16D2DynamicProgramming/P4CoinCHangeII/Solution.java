package Practice.C16D2DynamicProgramming.P4CoinCHangeII;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        // int amount = 5;
        // int[] coins = new int[]{1, 2, 5};

        int amount = 3;
        int[] coins = new int[]{2};

        // int amount = 10;
        // int[] coins = new int[]{10};

        int result = change(amount, coins);
        System.out.println(result);
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if(a >= coins[i]) {
                    dp[i][a] = dp[i + 1][a];
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }

        return dp[0][amount];
    }
}
