package C8Tries.P1ImplementTriePrefixTree;

public class Solution {
    private TrieNode root;

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        root = new TrieNode();
        insert("apple");
        boolean resultOne = search("apple");
        System.out.println(resultOne);
        boolean resultTwo = search("app");
        System.out.println(resultTwo);
        boolean resultThree = startsWith("app");
        System.out.println(resultThree);
    }

    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            if(cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            int i = c - 'a';
            if(cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }

        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c: prefix.toCharArray()) {
            int i = c - 'a';
            if(cur.children[i] == null) {
                return false;
            }
            cur = cur.children[i];
        }

        return true;
    }
}
