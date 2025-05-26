package Practice.C9BackTracking.P7PalindromePartitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        // String input = "aab";
        String input = "a";

        List<List<String>> result = partition(input);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return res;
    }

    private void dfs(int j, int i, String s) {
        if(i >= s.length()) {
            if(i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        if(isPali(s, j, i)){
            part.add(s.substring(j, i + 1));
            dfs(i + 1, i + 1, s);
            part.remove(part.size() - 1);
        }

        dfs(j, i + 1, s);
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
