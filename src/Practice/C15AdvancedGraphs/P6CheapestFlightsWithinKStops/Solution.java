package Practice.C15AdvancedGraphs.P6CheapestFlightsWithinKStops;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int n = 4;
        int[][] flights = new int[][]{
                {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

//        int n = 3;
//        int[][] flights = new int[][]{
//                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
//        };
//        int src = 0;
//        int dst = 2;
//        int k = 1;

//        int n = 3;
//        int[][] flights = new int[][]{
//                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
//        };
//        int src = 0;
//        int dst = 2;
//        int k = 0;

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int[] flight: flights) adj[flight[0]].add(new int[]{flight[1], flight[2]});

        dist[src][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int cst = top[0], node = top[1], stops = top[2];
            if(node == dst) return cst;
            if(stops == k || dist[node][stops + 1] < cst) continue;
            for(int[] neighbor: adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if(dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }

        return -1;
    }
}
