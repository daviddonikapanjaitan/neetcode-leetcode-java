package Practice.C8Tries.P2DesignAddAndSearchWordsDataStructure;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> store;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        store = new ArrayList<>();
        addWord("bad");
        addWord("dad");
        addWord("mad");
        boolean one = search("pad");
        boolean two = search("bad");
        boolean three = search(".ad");
        boolean four = search("b..");
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
    }

    public void addWord(String word) {
        store.add(word);
    }

    public boolean search(String word) {
        for(String w: store) {
            if(w.length() != word.length()) continue;
            int i = 0;
            while (i < w.length()) {
                if(w.charAt(i) == word.charAt(i) ||
                    word.charAt(i) == '.'
                ){
                    i++;
                } else {
                    break;
                }
            }
            if(i == w.length()) {
                return true;
            }
        }

        return false;
    }
}
