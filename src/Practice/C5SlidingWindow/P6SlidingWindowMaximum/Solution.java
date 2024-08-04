package Practice.C5SlidingWindow.P6SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n -k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0, r = 0;
        while (r < n) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offer(r);

            if(l > q.peekFirst()){
                q.pollFirst();
            }

            if(r + 1 >= k) {
                output[l] = nums[q.peekFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}
