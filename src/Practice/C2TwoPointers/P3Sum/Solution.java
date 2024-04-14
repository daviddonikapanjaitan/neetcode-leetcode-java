package Practice.C2TwoPointers.P3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        LinkedList<List<Integer>> sol = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if(nums[left] + nums[right] == target){
                        ArrayList<Integer> miniSol = new ArrayList<>();
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        sol.add(miniSol);
                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] > target){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return sol;
    }
}
