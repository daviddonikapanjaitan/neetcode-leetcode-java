package C11Graphs.P5RottingOranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] input = new int[][]{
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}
//        };

//        int[][] input = new int[][]{
//                {2, 1, 1},
//                {0, 1, 1},
//                {1, 0, 1}
//        };
        int[][] input = new int[][]{
                {0, 2},
        };

        int result =  orangesRotting(input);
        System.out.println(result);
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    fresh++;
                }
                if(grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir: directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row >= 0 && row < grid.length &&
                        col >= 0 && col < grid[0].length &&
                            grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
