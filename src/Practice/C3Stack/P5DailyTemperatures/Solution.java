package Practice.C3Stack.P5DailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        // int[] inputArray = new int[] {73,74,75,71,69,72,76,73};
        // int[] inputArray = new int[] {30,40,50,60};
        int[] inputArray = new int[] {30,60,90};
        int[] result = dailyTemperatures(inputArray);
        System.out.println(Arrays.toString(result));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            stack.add(currDay);
        }

        return ans;
    }
}
