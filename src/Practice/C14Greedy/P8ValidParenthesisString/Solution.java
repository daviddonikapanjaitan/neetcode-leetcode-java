package Practice.C14Greedy.P8ValidParenthesisString;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        String input = "()";
        // String input = "(*)";
        // String input = "(*))";

        boolean result = checkValidString(input);
        System.out.println(result);
    }

    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for(char c: s.toCharArray()) {
            if(c == '(') {
                leftMin++;
                leftMax++;
            } else if(c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if(leftMax < 0) {
                return false;
            }
            if(leftMin < 0) {
                leftMin = 0;
            }
        }

        return leftMin == 0;
    }
}
