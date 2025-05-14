package Practice.C1ArraysAndHashing.P1ContainsDuplicate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    public static void main(String[] args) {
        // List<Integer> inputArrays = List.of(1, 2, 3, 1);
        // List<Integer> inputArrays = List.of(1, 2, 3, 4);
        int[] nums = new int[]{1, 2, 3, 4};

        Map<Integer, Integer> mapCounter = new LinkedHashMap<>();

        AtomicBoolean result = new AtomicBoolean(false);
        for (int i = 0; i < nums.length; i++) {
            if(mapCounter.get(nums[i]) == null) {
                mapCounter.put(nums[i], mapCounter.getOrDefault(nums[i], 1) + 1);
            } else {
                result.set(true);
                break;
            }
        }

        System.out.println(result);
    }
}
