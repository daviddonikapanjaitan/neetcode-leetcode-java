package C9BackTracking.P8LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
      "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // String input = "23";
        String input = "2";

        List<String> result = letterCombinations(input);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backTrack(0, "", digits);
        return res;
    }

    private void backTrack(int i, String curStr, String digits) {
        if(curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c: chars.toCharArray()) {
            backTrack(i + 1, curStr + c, digits);
        }
    }
}
