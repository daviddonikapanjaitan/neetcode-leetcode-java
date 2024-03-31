package C1ArraysAndHashing.P2ValidAnagram;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        // String s = "ab";
        // String t = "a";
//        String s = "aacc";
//        String t = "ccac";

        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        String[] sChars = s.split("");
        String[] tChars = t.split("");

        Arrays.sort(sChars);
        Arrays.sort(tChars);
        System.out.println(Arrays.toString(sChars));
        System.out.println(Arrays.toString(tChars));

        if(sChars.length != tChars.length){
            return false;
        } else {
            for (int i = 0; i < sChars.length; i++) {
                if(!Objects.equals(sChars[i], tChars[i])){
                    return false;
                }
            }
        }

        return true;
    }
}
