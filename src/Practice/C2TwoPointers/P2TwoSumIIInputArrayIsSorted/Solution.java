package Practice.C2TwoPointers.P2TwoSumIIInputArrayIsSorted;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;
        int num_a, num_b;

        while (a_pointer < b_pointer){
            num_a = numbers[a_pointer];
            num_b = numbers[b_pointer];

            if(num_a + num_b == target) break;

            if(num_a + num_b < target){
                a_pointer++;
                continue;
            }

            b_pointer--;
        }

        return new int[]{a_pointer + 1, b_pointer + 1};
    }
}
