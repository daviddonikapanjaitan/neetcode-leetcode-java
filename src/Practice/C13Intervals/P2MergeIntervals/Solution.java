package Practice.C13Intervals.P2MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
//        int[][] intervals = new int[][]{
//                {1, 4}, {4, 5}
//        };

        int[][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] interval: intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }

        List<int[]> res = new ArrayList<>();
        int have = 0;
        int[] interval = new int[2];

        for(int point: map.keySet()){
            if(have == 0) interval[0] = point;
            have += map.get(point);
            if(have == 0) {
                interval[1] = point;
                res.add(new int[]{interval[0], interval[1]});
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
