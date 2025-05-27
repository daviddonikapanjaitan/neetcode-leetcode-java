package C10HeapPriorityQueue.P1KthLargestElementInAStream;

import java.util.PriorityQueue;

public class Solution {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public static void main(String[] args) {
        Solution solution = new Solution(3, new int[]{4,5,8,2});
        int one = solution.add(3);
        int two = solution.add(5);
        int three = solution.add(10);
        int four = solution.add(9);
        int five = solution.add(4);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        System.out.println(five);

//        Solution solution = new Solution(4, new int[]{7,7,7,7,8,3});
//        int one = solution.add(2);
//        int two = solution.add(10);
//        int three = solution.add(9);
//        int four = solution.add(9);
//
//        System.out.println(one);
//        System.out.println(two);
//        System.out.println(three);
//        System.out.println(four);
    }

    public Solution(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
