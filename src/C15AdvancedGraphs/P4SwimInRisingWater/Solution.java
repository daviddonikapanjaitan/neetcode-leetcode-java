package C15AdvancedGraphs.P4SwimInRisingWater;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[][] solution = new int[][]{
                {0, 2}, {1, 3}
        };

//        int[][] solution = new int[][]{
//                {0, 1, 2, 3, 4},
//                {24, 23, 22, 21, 5},
//                {12, 13, 14, 15, 16},
//                {11, 17, 18, 19, 20},
//                {10, 9, 8, 7, 6}
//        };

        int result = swimInWater(solution);
        System.out.println(result);
    }

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        int[][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c =curr[2];
            if(r == N - 1 && c == N - 1) {
                return t;
            }
            for(int[] dir: directions) {
                int neiR = r + dir[0], neiC = c + dir[1];
                if(neiR >= 0 && neiC >= 0 && neiR < N &&
                    neiC < N && !visit[neiR][neiC]) {
                    visit[neiR][neiC] = true;
                    minHeap.offer(new int[]{
                            Math.max(t, grid[neiR][neiC]),
                            neiR, neiC
                    });
                }
            }
        }

        return N * N;
    }
}
