package C2TwoPointers.P1ValidPalindrome;

public class Solution2 {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        // String input = "hannah";
        // String input = " ";
        // String input = "race a car";
        boolean result = isPalindrome(input);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            char start = s.charAt(i);
            char end = s.charAt(j);

            if(!Character.isLetterOrDigit(start)){
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }

            if(Character.toLowerCase(start) != Character.toLowerCase(end)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
