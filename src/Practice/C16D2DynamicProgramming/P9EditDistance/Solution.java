package Practice.C16D2DynamicProgramming.P9EditDistance;

public class Solution {
    private int[][] dp;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        String word1 = "horse";
        String word2 = "ros";

        // String word1 = "intention";
        // String word2 = "execution";

        int result = minDistance(word1, word2);
        System.out.println(result);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(0, 0, word1, word2, m, n);
    }

    private int dfs(int i, int j, String word1, String word2, int m, int n) {
        if(i == m) return n - j;
        if (j == n) return m - i;
        if (dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = dfs(i + 1, j + 1, word1, word2, m, n);
        } else {
            int res = Math.min(dfs(i + 1, j, word1, word2, m, n),
                    dfs(i, j + 1, word1, word2, m, n));
            res = Math.min(res, dfs(i + 1, j + 1, word2, word2, m, n));
            dp[i][j] = res + 1;
        }

        return dp[i][j];
    }
}
