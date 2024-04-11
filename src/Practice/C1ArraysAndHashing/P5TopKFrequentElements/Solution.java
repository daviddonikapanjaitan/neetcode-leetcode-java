package Practice.C1ArraysAndHashing.P5TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        int[] listInteger = new int[] {1,1,1,2,2,3};
        int[] listInteger = new int[] {1,2};
        int size = 2;
        int[] result = topKFrequent(listInteger, size);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for(Integer i: map.keySet()){
            arr[map.get(i)].add(i);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].size(); j++) {
                if(idx == k){
                    return res;
                }

                res[idx++] = arr[i].get(j);
            }
        }

        return res;
    }
}
