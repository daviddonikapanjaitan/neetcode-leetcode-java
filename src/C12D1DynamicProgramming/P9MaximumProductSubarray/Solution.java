package C12D1DynamicProgramming.P9MaximumProductSubarray;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] nums = new int[]{2, 3, -2, 4};
        // int[] nums = new int[]{-2, 0, -1};
        int result = maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
         int res = nums[0];
         int curMin = 1, curMax = 1;

         for(int num: nums) {
             int tmp = curMax * num;
             curMax = Math.max(Math.max(num * curMax, num * curMin), num);
             curMin = Math.min(Math.min(tmp, num * curMin), num);
             res = Math.max(res, curMax);
         }

         return res;
    }
}
