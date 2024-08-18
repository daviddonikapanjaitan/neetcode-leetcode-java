package C7Trees.P1InvertBinaryTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode invert = invertTree(root);
        System.out.println(invert.left.val);
        System.out.println(invert.right.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode node = new TreeNode(root.val);

        node.right = invertTree(root.left);
        node.left = invertTree(root.right);

        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
