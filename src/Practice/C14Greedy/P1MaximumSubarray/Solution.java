package Practice.C14Greedy.P1MaximumSubarray;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] input = new int[]{1};
        // int[] input = new int[]{5, 4, -1, 7, 8};

        int result = maxSubArray(input);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int maxSub = nums[0], curSum = 0;
        for(int num: nums) {
            if(curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSub = Math.max(maxSub, curSum);
        }

        return maxSub;
    }
}
