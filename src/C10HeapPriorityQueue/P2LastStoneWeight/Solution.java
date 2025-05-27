package C10HeapPriorityQueue.P2LastStoneWeight;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // int[] stones = new int[] {2,7,4,1,8,1};
        int[] stones = new int[] {1};
        int result = lastStoneWeight(stones);
        System.out.println(result);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s: stones) {
            minHeap.offer(-s);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if(second > first) {
                minHeap.offer(first - second);
            }
        }

        minHeap.offer(0);
        return Math.abs(minHeap.peek());
    }
}
