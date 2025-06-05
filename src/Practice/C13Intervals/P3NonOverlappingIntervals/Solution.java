package Practice.C13Intervals.P3NonOverlappingIntervals;

import java.util.Arrays;

public class Solution {
    private int[] memo;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[][] intervals = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };

//        int[][] intervals = new int[][]{
//                {1, 2}, {1, 2}, {1, 2}
//        };

//        int[][] intervals = new int[][]{
//                {1, 2}, {2, 3}
//        };
        int result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        int maxNonOverlapping = dfs(intervals, 0);
        return  n - maxNonOverlapping;
    }

    private int dfs(int[][] intervals, int i) {
        if(i >= intervals.length) return 0;
        if(memo[i] != -1) return memo[i];

        int res = 1;
        for (int j = i + 1; j < intervals.length; j++) {
            if(intervals[i][1] <= intervals[j][0]) {
                res = Math.max(res, 1 + dfs(intervals, j));
            }
        }

        memo[i] = res;
        return res;
    }
}
