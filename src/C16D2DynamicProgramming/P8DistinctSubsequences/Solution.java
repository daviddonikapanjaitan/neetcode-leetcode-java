package C16D2DynamicProgramming.P8DistinctSubsequences;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        String s = "rabbbit";
        String t = "rabbit";

        // String s = "babgbag";
        // String t = "bag";

        int result = numDistinct(s, t);

        System.out.println(result);
    }

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
