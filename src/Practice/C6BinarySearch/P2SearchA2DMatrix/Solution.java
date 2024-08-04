package Practice.C6BinarySearch.P2SearchA2DMatrix;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        // int target = 3;
        int target = 13;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if(target > matrix[row][COLS - 1]){
                top = row + 1;
            } else if(target < matrix[row][0]){
                bot = row - 1;
            } else {
                break;
            }
        }

        if(!(top <= bot)){
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if(target > matrix[row][m]){
                l = m + 1;
            } else if(target < matrix[row][m]){
                r = m -1;
            } else {
                return true;
            }
        }

        return false;
    }
}
