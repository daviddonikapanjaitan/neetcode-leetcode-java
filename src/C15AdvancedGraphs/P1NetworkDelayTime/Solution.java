package C15AdvancedGraphs.P1NetworkDelayTime;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] times = new int[][]{
//                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
//        };
//        int n = 4;
//        int k = 2;

//        int[][] times = new int[][]{
//                {1, 2, 1}
//        };
//        int n = 2;
//        int k = 1;

        int[][] times = new int[][]{
                {1, 2, 1}
        };
        int n = 2;
        int k = 2;

        int result = networkDelayTime(times, n, k);
        System.out.println(result);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] time: times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];
            if(visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            t = w1;

            if(edges.containsKey(n1)) {
                for(int[] next: edges.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    if(!visited.contains(n2)) {
                        minHeap.offer(new int[] {w1 + w2, n2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
