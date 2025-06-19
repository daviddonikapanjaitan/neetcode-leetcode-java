package C18MathAndGeomatry.P5PlusOne;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] digits = new int[]{1,2,3};
        // int[] digits = new int[]{4, 3, 2, 1};
        int[] digits = new int[]{9};

        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
