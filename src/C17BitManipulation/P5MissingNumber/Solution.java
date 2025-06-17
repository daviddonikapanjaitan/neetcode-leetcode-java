package C17BitManipulation.P5MissingNumber;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] input = new int[]{3,0,1};
        // int[] input = new int[]{0, 1};
        int[] input = new int[]{9,6,4,2,3,5,7,0,1};

        int result = missingNumber(input);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;
        for (int i = 0; i < n; i++) {
            xorr ^= i ^ nums[i];
        }

        return xorr;
    }
}
