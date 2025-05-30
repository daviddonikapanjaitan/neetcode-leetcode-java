package C11Graphs.P6PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int ROWS, COLS;
    boolean pacific, atlantic;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[][] input = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> result = pacificAtlantic(input);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                pacific = false;
                atlantic = false;
                dfs(heights, r, c, Integer.MAX_VALUE);
                if(pacific && atlantic) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevVal) {
        if(r < 0 || c < 0) {
            pacific = true;
            return;
        }
        if(r >= ROWS || c >= COLS) {
            atlantic = true;
            return;
        }
        if(heights[r][c] > prevVal) {
            return;
        }

        int tmp = heights[r][c];
        heights[r][c] = Integer.MAX_VALUE;
        for(int[] dir: directions) {
            dfs(heights, r + dir[0], c+ dir[1], tmp);
            if(pacific && atlantic){
                break;
            }
        }
        heights[r][c] = tmp;
    }
}
