package Practice.C12D1DynamicProgramming.P7DecodeWays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        String s = "12";
        // String s = "226";
        // String s = "06";
        int result = numDecodings(s);
        System.out.println(result);
    }

    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, Map<Integer, Integer> dp) {
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        if(s.charAt(i) == '0'){
            return 0;
        }

        int res = dfs(s, i + 1, dp);
        if(i + 1 < s.length() && (s.charAt(i) == '1' ||
                s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
            res += dfs(s, i + 2, dp);
        }
        dp.put(i, res);
        return res;
    }
}
