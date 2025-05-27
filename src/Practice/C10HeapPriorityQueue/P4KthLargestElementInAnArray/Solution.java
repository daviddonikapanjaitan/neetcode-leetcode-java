package Practice.C10HeapPriorityQueue.P4KthLargestElementInAnArray;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;

        // int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        // int k = 4;

        int result = findKthLargest(nums, k);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
