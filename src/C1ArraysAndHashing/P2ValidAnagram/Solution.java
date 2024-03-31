package C1ArraysAndHashing.P2ValidAnagram;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
//        String s = "anagram";
//        String t = "nagaram";
        // String s = "ab";
        // String t = "a";
        String s = "aacc";
        String t = "ccac";

        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if(sChars.length != tChars.length){
            return false;
        }

        Map<String, Integer> store = new LinkedHashMap<>();

        for (int i = 0; i < sChars.length; i++) {
            store.put(String.valueOf(sChars[i]), store.getOrDefault(String.valueOf(sChars[i]), 0) + 1);
        }

        boolean result = true;
        for (char tChar : tChars) {
            int value = store.getOrDefault(String.valueOf(tChar), 0) - 1;
            store.put(String.valueOf(tChar), value);
            System.out.println(store);
            if (value == -1) {
                result = false;
                break;
            }

        }

        return result;
    }
}
