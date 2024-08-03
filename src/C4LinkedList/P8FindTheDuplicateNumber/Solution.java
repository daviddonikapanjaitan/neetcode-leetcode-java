package C4LinkedList.P8FindTheDuplicateNumber;

public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,4,2,2};
//        int[] nums = new int[]{3,1,3,4,2};
        int[] nums = new int[]{3,3,3,3,3};
        int result = findDuplicate(nums);
        System.out.println(result);
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) {
                return slow;
            }
        }
    }
}
