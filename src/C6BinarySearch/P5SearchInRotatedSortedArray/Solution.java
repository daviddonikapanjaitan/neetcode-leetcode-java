package C6BinarySearch.P5SearchInRotatedSortedArray;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[] {4,5,6,7,0,1,2}; int target1 = 0;
        // int[] nums1 = new int[] {4,5,6,7,0,1,2}; int target1 = 3;
        // int[] nums1 = new int[] {1}; int target1 = 0;
        int result = search(nums1, target1);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[l] <= nums[mid]) {
                if(target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if(target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
