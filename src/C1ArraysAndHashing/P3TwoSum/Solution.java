package C1ArraysAndHashing.P3TwoSum;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] resultNums = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    resultNums[0] = i;
                    resultNums[1] = j;
                }
            }
        }

        return resultNums;
    }
}
