package C3Stack.P7LargestRectangleInHistorgram;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }

    public static int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        int start;
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            int curHt = heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > curHt){
                Pair<Integer,Integer> pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(new Pair(start,curHt));
        }

        while(!stack.isEmpty()){
            Pair<Integer,Integer> pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            area = Math.max(area, h * (n - index));
        }
        return area;
    }

    public static class Pair<K, V> {

        private final K key;
        private final V value;

        public <K, V> Pair<K, V> createPair(K key, V value) {
            return new Pair<K, V>(key, value);
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
