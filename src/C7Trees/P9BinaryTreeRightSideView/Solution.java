package C7Trees.P9BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(5);
//        root.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        List<Integer> result =rightSideView(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        if(res.size() == depth) {
            res.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
