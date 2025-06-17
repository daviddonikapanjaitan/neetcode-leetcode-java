package C17BitManipulation.P1SingleNumber;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] input = new int[]{2, 2, 1};
        // int[] input = new int[]{4, 1, 2, 1, 2};
        int[] input = new int[]{1};

        int result = singleNumber(input);
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums) {
            res ^= num;
        }

        return res;
    }
}
