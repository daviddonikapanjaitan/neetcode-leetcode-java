package Practice.C6BinarySearch.P1BinarySearch;

public class Solution {

    public static void main(String[] args) {
        // int[] nums = new int[]{-1,0,3,5,9,12};
        // int target = 9;
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        int result = search(nums, target);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if(nums[m] > target) {
                r = m - 1;
            } else if(nums[m] < target){
                l = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
