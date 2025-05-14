package Practice.C1ArraysAndHashing.P4GroupAnagrams;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
        // String[] input = new String[]{"", "", ""};
        List<List<String>> result = groupAnagrams(input);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapper = new LinkedHashMap<>();

        for (int i = strs.length - 1; i > -1; i--) {
            String[] anagramArray = strs[i].split("");
            Arrays.sort(anagramArray);
            String joinStr = String.join("", anagramArray);
            boolean isKeyExist = !Objects.isNull(mapper.get(joinStr));

            List<String> arrays = new ArrayList<>();
            if(isKeyExist){
                arrays = mapper.get(joinStr);
                arrays.add(strs[i]);
            } else {
                arrays.add(strs[i]);
            }

            mapper.put(joinStr, arrays);
        }

        return new ArrayList<>(mapper.values());
    }
}
