package Practice.C13Intervals.P1InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
         int[][] intervals = new int[][]{
                 {1, 3}, {6, 9}
         };
         int[] newInterval = new int[]{2, 5};

//        int[][] intervals = new int[][]{
//                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
//        };
//        int[] newInterval = new int[]{4, 8};

        int[][] result = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
