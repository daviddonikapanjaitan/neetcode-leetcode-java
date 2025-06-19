package C18MathAndGeomatry.P4HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int input = 19;
        int input = 2;
        boolean result = isHappy(input);
        System.out.println(result);
    }

    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while(!visit.contains(n)) {
            visit.add(n);
            n = sumOfSquares(n);
            if(n == 1) {
                return true;
            }
        }

        return false;
    }

    private int sumOfSquares(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }

        return output;
    }
}
