package C14Greedy.P5HandOfStraights;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;

        // int[] hand = new int[]{1, 2, 3, 4, 5};
        // int groupSize = 4;

        boolean result = isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for(int num: hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int num: hand) {
            int start = num;
            while (count.getOrDefault(start - 1, 0) > 0) start--;
            while (start <= num) {
                while (count.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if(count.getOrDefault(i, 0) == 0) return false;
                        count.put(i, count.get(i) - 1);
                    }
                }
                start++;
            }
        }

        return true;
    }
}
