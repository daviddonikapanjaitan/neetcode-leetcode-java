package C6BinarySearch.P3KokoEatingBananas;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // int[] piles = new int[]{3,6,7,11};
        // int h = 8;
        // int[] piles = new int[]{30,11,23,4,20};
        // int h = 5;
        int[] piles = new int[]{30,11,23,4,20};
        int h = 6;
        int result = minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;

            int totalTime = 0;
            for(int p: piles) {
                totalTime += Math.ceil((double) p / k);
            }
            if(totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
