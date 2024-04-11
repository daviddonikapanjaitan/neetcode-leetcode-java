package Practice.C1ArraysAndHashing.P6ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // int[] nums = new int[]{1,2,3,4};
        int[] nums = new int[]{-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int right = 1, left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }

        return arr;
    }
}
