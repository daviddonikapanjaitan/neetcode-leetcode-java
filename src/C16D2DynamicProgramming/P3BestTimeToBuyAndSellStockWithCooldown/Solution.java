package C16D2DynamicProgramming.P3BestTimeToBuyAndSellStockWithCooldown;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] input = new int[]{1, 2, 3, 0, 2};
        int[] input = new int[]{1};

        int result = maxProfit(input);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if(i >= prices.length) {
            return 0;
        }

        String key = i + "-" + buying;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(i + 1, buying, prices);
        if(buying){
            int buy = dfs(i + 1, false, prices) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}
