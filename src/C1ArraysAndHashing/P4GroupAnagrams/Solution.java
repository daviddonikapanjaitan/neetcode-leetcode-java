package C1ArraysAndHashing.P4GroupAnagrams;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        // String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] input = new String[]{"", "", ""};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }

    public static boolean isAnagram(String[] listOne, String[] listTwo){
        Arrays.sort(listOne);
        Arrays.sort(listTwo);
        boolean isAnagram = true;

        if(listOne.length != listTwo.length){
            isAnagram = false;
        } else {
            for (int k = 0; k < listOne.length; k++) {
                if (!Objects.equals(listOne[k], listTwo[k])) {
                    isAnagram = false;
                    break;
                }
            }
        }

        return isAnagram;
    }
}
