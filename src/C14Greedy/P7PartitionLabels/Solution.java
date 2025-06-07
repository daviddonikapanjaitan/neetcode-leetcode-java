package C14Greedy.P7PartitionLabels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // String input = "ababcbacadefegdehijhklij";
        String input = "eccbbbbdec";

        List<Integer> result = partitionLabels(input);
        System.out.println(result);
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if(i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
