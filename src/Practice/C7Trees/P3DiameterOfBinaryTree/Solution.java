package Practice.C7Trees.P3DiameterOfBinaryTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = diameterOfBinaryTree(root);
        System.out.println(result);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private static int dfs(TreeNode root, int[] res) {
        if(root == null){
            return 0;
        }

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
