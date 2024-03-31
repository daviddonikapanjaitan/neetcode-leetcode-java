package C1ArraysAndHashing.P1ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> setter = new HashSet();

        for(int i = 0; i < nums.length; i++){
            if(setter.contains(nums[i])){
                return true;
            } else{
                setter.add(nums[i]);
            }
        }


        return false;
    }
}
