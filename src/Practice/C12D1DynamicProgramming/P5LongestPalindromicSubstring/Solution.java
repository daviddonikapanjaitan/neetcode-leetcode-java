package Practice.C12D1DynamicProgramming.P5LongestPalindromicSubstring;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // String input = "babad";
        String input = "cbbd";

        String result = longestPalindrome(input);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    if (resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
