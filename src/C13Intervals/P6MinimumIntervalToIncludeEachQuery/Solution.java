package C13Intervals.P6MinimumIntervalToIncludeEachQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[][] intervals = new int[][]{
                {1, 4}, {2, 4}, {3, 6}, {4, 4}
        };
        int[] queries = new int[]{2, 3, 4, 5};

//        int[][] intervals = new int[][]{
//                {2, 3}, {2, 5}, {1, 8}, {20, 25}
//        };
//        int[] queries = new int[]{2, 19, 5, 22};

        int[] results = minInterval(intervals, queries);
        System.out.println(Arrays.toString(results));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            events.add(new int[]{intervals[i][0], 0, intervals[i][1] - intervals[i][0] + 1, i});
            events.add(new int[]{intervals[i][1], 2, intervals[i][1] - intervals[i][0] + 1, i});
        }

        for (int i = 0; i < queries.length; i++) {
            events.add(new int[] {queries[i], 1, i});
        }

        events.sort((a, b) -> a[0] != b[0] ?
                Integer.compare(a[0], b[0]) :
                Integer.compare(a[1], b[1]));

        int[] ans = new int[queries.length];
        Arrays.fill(ans, - 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] inactive = new boolean[intervals.length];

        for(int[] event: events) {
            if(event[1] == 0) {
                pq.offer(new int[]{event[2], event[3]});
            } else if (event[1] == 2) {
                inactive[event[3]] = true;
            } else {
                while (!pq.isEmpty() && inactive[pq.peek()[1]]){
                    pq.poll();
                }
                if(!pq.isEmpty()) {
                    ans[event[2]] = pq.peek()[0];
                }
            }
        }

        return ans;
    }
}
