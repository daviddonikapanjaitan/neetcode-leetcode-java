package Practice.C10HeapPriorityQueue.P5TaskScheduler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        // int n = 2;

        // char[] tasks = new char[]{'A', 'C', 'A', 'B', 'D', 'B'};
        // int n = 1;

        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;

        int result = leastInterval(tasks, n);
        System.out.println(result);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task: tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt: count) {
            if(cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
