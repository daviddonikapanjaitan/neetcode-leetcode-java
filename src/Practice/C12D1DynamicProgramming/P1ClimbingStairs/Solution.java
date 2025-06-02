package Practice.C12D1DynamicProgramming.P1ClimbingStairs;

public class Solution {
    int[] cache;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        // int input = 2;
        int input = 3;
        int output = climStairs(input);
        System.out.println(output);
    }

    public int climStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if(i >= n) return i == n ? 1 : 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
