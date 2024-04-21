package C3Stack.P1ValidParentheses;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String input = "()[]{}";
        // String input = "(]";
        boolean result = isValid(input);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() &&
                    (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
            ){
                return false;
            } else {
                if(s.charAt(i) == ')' && stack.peek() == '('){
                    stack.pop();
                } else if(s.charAt(i) == '}' && stack.peek() == '{'){
                    stack.pop();
                } else if(s.charAt(i) == ']' && stack.peek() == '['){
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }
}
