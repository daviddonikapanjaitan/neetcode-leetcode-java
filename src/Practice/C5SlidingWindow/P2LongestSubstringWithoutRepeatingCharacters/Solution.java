package Practice.C5SlidingWindow.P2LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        // String input = "abcabcbb";
        // String input = "bbbbb";
        String input = "pwwkew";

        int result = lengthOfLongestSubstring(input);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return  res;
    }
}
