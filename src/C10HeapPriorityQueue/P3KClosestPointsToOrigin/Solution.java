package C10HeapPriorityQueue.P3KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] points = new int[][]{
//            {1, 3},
//            {-2, 2},
//        };
//        int k = 1;

        int[][] points = new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k = 2;

        int[][] results = kClosest(points, k);
        System.out.println(Arrays.deepToString(results));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],
                                          a[0] * a[0] + a[1] * a[1])
        );

        for(int[] point: points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }

        return res;
    }
}
