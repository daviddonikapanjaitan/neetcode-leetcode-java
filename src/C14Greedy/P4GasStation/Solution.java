package C14Greedy.P4GasStation;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] gas = new int[]{1, 2, 3, 4, 5};
        // int[] cost = new int[]{3, 4, 5, 1, 2};

        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};

        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);

            if(total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;
    }
}
