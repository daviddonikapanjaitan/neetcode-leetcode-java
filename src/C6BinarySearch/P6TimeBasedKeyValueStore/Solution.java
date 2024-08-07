package C6BinarySearch.P6TimeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static Map<String, List<Pair<Integer, String>>> keyStore;

    public static void main(String[] args) {
        keyStore = new HashMap<>();
        set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        String result = get("foo", 1);         // return "bar"
        System.out.println(result);
        String result1 = get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println(result);
        set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        String result2 = get("foo", 4);         // return "bar2"
        System.out.println(result2);
        String result3 = get("foo", 5);         // return "bar2"
        System.out.println(result3);
    }

    public static void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public static String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        private Pair(K key, V value) {
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
