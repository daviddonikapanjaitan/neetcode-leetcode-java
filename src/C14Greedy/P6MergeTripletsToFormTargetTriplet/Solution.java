package C14Greedy.P6MergeTripletsToFormTargetTriplet;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] input = new int[][]{
//                {2, 5, 3}, {1, 8, 4}, {1, 7, 5}
//        };
//        int[] target = new int[]{2, 7, 5};

//        int[][] input = new int[][]{
//                {3, 4, 5}, {4, 5, 6}
//        };
//        int[] target = new int[]{3, 2, 4};

        int[][] input = new int[][]{
                {2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}
        };
        int[] target = new int[]{5, 5, 5};

        boolean result = mergeTriplets(input, target);
        System.out.println(result);
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();

        for(int[] t: triplets) {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            for(int i = 0; i < t.length; i++) {
                if(t[i] == target[i]) {
                    good.add(i);
                }
            }
        }

        return good.size() == 3;
    }
}
