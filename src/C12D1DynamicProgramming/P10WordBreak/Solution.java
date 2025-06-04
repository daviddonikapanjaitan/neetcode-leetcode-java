package C12D1DynamicProgramming.P10WordBreak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Integer, Boolean> memo;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        // String s = "applepenapple";
        // List<String> wordDict = List.of("apple", "pen");

        // String s = "catsandog";
        // List<String> wordDict = List.of("cats","dog","sand","and","cat");

        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i) {
        if(memo.containsKey(i)) {
            return memo.get(i);
        }

        for(String w: wordDict) {
            if(i + w.length() <= s.length() &&
                s.substring(i, i + w.length()).equals(w)) {
                if(dfs(s, wordDict, i + w.length())){
                    memo.put(i, true);
                    return true;
                }
            }
        }

        memo.put(i, false);
        return false;
    }
}
