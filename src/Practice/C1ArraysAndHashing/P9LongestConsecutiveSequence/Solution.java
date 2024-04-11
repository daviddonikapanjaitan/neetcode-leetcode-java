package Practice.C1ArraysAndHashing.P9LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        // int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }

    public static int longestConsecutive(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }

        int longest = 1;
        for(int num: nums) {
            if(!hs.contains(num - 1)){
                int count = 1;
                while (hs.contains(num + 1)){
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
            }

            if(longest > nums.length / 2){
                break;
            }
        }

        return longest;
    }
}
