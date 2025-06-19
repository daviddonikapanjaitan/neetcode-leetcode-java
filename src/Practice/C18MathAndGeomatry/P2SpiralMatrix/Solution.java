package Practice.C18MathAndGeomatry.P2SpiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] matrix = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        dfs(m, n, 0, -1, 0, 1, matrix, res);
        return res;
    }

    private void dfs(int row, int col, int r, int c, int dr, int dc, int[][] matrix, List<Integer> res){
        if(row == 0 || col == 0) return;

        for (int i = 0; i < col; i++) {
            r += dr;
            c += dc;
            res.add(matrix[r][c]);
        }

        dfs(col, row - 1, r, c, dc, -dr, matrix, res);
    }
}
