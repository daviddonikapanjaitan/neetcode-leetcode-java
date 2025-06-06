package C14Greedy.P2JumpGame;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] input = new int[]{2, 3, 1, 1, 4};
        int[] input = new int[]{3, 2, 1, 0, 4};

        boolean result = canJump(input);
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
