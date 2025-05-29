package C11Graphs.P4WallsAndGates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[][] grid = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        islandsAndTreasure(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        boolean[][] visit = new boolean[ROWS][COLS];
        visit[r][c] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                if(grid[row][col] == 0) return steps;
                for(int[] dir: directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS &&
                        !visit[nr][nc] && grid[nr][nc] != -1) {
                        visit[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }

        return INF;
    }

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if(grid[r][c] == INF) {
                    grid[r][c] = bfs(grid, r, c);
                }
            }
        }
    }
}
