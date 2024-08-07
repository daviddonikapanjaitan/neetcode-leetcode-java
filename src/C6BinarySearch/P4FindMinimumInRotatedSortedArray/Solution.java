package C6BinarySearch.P4FindMinimumInRotatedSortedArray;

public class Solution {

    public static void main(String[] args) {
        // int[] nums1 = new int[] {3,4,5,1,2};
        // int[] nums2 = new int[] {4,5,6,7,0,1,2};
        int[] nums3 = new int[] {11,13,15,17};
        int result = findMin(nums3);
        System.out.println(result);
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return 0;
    }
}
