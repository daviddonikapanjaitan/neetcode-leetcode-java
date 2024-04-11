package C2TwoPointers.P1ValidPalindrome;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        // String input = "A man, a plan, a canal: Panama";
        // String input = "hannah";
        // String input = " ";
        String input = "race a car";
        boolean result = isPalindrome(input);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz123456789";
        char[] charAlphanumeric = alphanumeric.toCharArray();
        HashSet<String> containsChar = new HashSet<>();
        for(char alphaChar: charAlphanumeric){
            containsChar.add(String.valueOf(alphaChar));
        }

        String input = s.toLowerCase();
        char[] editChars = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char editChar: editChars){
            if(containsChar.contains(String.valueOf(editChar))){
                builder.append(editChar);
            }
        }

        String resultString = builder.toString();
        char[] resultChar = resultString.toCharArray();
        boolean result = true;
        for (int i = 0; i < resultChar.length; i++) {
            if (!String.valueOf(resultChar[i]).equals(String.valueOf(resultChar[resultChar.length - i - 1]))) {
                result = false;
                break;
            }
        }

        return result;
    }
}
