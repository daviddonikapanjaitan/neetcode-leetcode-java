package C5SlidingWindow.P3LongestRepeatingSubstringWithReplacement;

public class Solution {

    public static void main(String[] args) {
        String input = "ABAB";
        // String input = "AABABBA";
        int result = characterReplacement(input, 10);
        System.out.println(result);
    }

    public static int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);

            if(j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}
