package Practice.C3Stack.P3EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        // String[] inputTokens = new String[]{"2","1","+","3","*"};
        // String[] inputTokens = new String[]{"4","13","5","/","+"};
        String[] inputTokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = evalRPN(inputTokens);
        System.out.println(result);
    }

    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")){
                stack.add(stack.pop() + stack.pop());
            } else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if(token.equals("*")){
                stack.add(stack.pop() * stack.pop());
            } else if (token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
