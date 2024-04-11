package Practice.C1ArraysAndHashing.P8EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> inputString = List.of("neet","code","love","you");
        // List<String> inputString = List.of("we","say",":","yes");

        String encoded = encode(inputString);
        System.out.println(encoded);
        List<String> decode =decode(encoded);
        System.out.println(Arrays.toString(decode.toArray()));
    }

    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str: strs){
            encodedString.append(str.length()).append("#").append(str);
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = i;
            while (str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
