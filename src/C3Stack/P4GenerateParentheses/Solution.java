package C3Stack.P4GenerateParentheses;

import java.util.*;

public class Solution {

    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> result = sol.generateParenthesis(3);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> generateParenthesis(int n ){
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n){
        if(openN == closedN && closedN == n) {
            Iterator<Character> vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if(openN < n){
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if(closedN < openN){
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}
