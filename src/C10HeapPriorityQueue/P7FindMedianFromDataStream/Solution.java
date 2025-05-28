package C10HeapPriorityQueue.P7FindMedianFromDataStream;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double one = medianFinder.findMedian();
        System.out.println(one);
        medianFinder.addNum(3);
        double two = medianFinder.findMedian();
        System.out.println(two);
    }

    public static class MedianFinder{
        private Queue<Integer> smallHeap;
        private Queue<Integer> largeHeap;

        public MedianFinder(){
            smallHeap = new PriorityQueue<>((a, b) -> b - a);
            largeHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            smallHeap.add(num);
            if(smallHeap.size() - largeHeap.size() > 1 ||
               !largeHeap.isEmpty() &&
               smallHeap.peek() > largeHeap.peek()
            ){
                largeHeap.add(smallHeap.poll());
            }
            if(largeHeap.size() - smallHeap.size() > 1){
                smallHeap.add(largeHeap.poll());
            }
        }

        public double findMedian() {
            if(smallHeap.size() == largeHeap.size()) {
                return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
            } else if (smallHeap.size() > largeHeap.size()) {
                return (double) smallHeap.peek();
            } else {
                return (double) largeHeap.peek();
            }
        }
    }
}
