package C8Tries.P3WordSearchII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };
        String[] words = new String[]{"eat", "oath"};

//        char[][] board = {
//                {'a', 'b'},
//                {'c', 'D'}
//        };
//        String[] words = new String[]{"abcb"};

        List<String> result = findWords(board, words);
        System.out.println("result: " + Arrays.toString(result.toArray()));
    }

    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length, COLS = board[0].length;
        List<String> res = new ArrayList<>();

        for(String word: words) {
            boolean flag = false;
            for (int r = 0; r < ROWS && !flag; r++) {
                for (int c = 0; c < COLS; c++) {
                    if(board[r][c] != word.charAt(0)) continue;
                    if(backtrack(board, r, c, word, 0)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }

        return res;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int i) {
        if(i == word.length()) return true;
        if(r < 0 || c < 0 || r>= board.length ||
            c >= board[0].length || board[r][c] != word.charAt(i)){
            return false;
        }
        board[r][c] = '*';
        boolean ret = backtrack(board, r + 1, c, word, i + 1) ||
                backtrack(board, r - 1, c, word, i + 1) ||
                backtrack(board, r, c + 1, word, i + 1) ||
                backtrack(board, r, c - 1, word, i + 1);
        board[r][c] = word.charAt(i);
        return ret;
    }
}
