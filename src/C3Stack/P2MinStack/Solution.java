package C3Stack.P2MinStack;

import java.util.Iterator;
import java.util.Stack;

public class Solution {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);

        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    public void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);

        Integer resultOne = solution.getMin();
        System.out.println(resultOne);

        solution.pop();

        Integer resultTwo = solution.top();
        System.out.println(resultTwo);

        Integer resultThree = solution.getMin();
        System.out.println(resultThree);
    }
}
