package Practice.C14Greedy.P3JumpGameII;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        // int[] nums = new int[]{2, 3, 0, 1, 4};
        int result = jump(nums);

        System.out.println(result);
    }

    public int jump(int[] nums) {
        int res = 0, l = 0, r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }

        return res;
    }
}
