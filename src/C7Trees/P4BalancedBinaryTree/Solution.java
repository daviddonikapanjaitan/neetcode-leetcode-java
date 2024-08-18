package C7Trees.P4BalancedBinaryTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode rootOne = new TreeNode(1);
        rootOne.left = new TreeNode(2);
        rootOne.right = new TreeNode(3);
        rootOne.right.left = new TreeNode(4);

        TreeNode rootTwo = new TreeNode(1);
        rootTwo.left = new TreeNode(2);
        rootTwo.right = new TreeNode(3);
        rootTwo.right.left = new TreeNode(4);
        rootTwo.right.left.left = new TreeNode(5);
        boolean result = isBalanced(rootOne);
        System.out.println(result);
        boolean resultTwo = isBalanced(rootTwo);
        System.out.println(resultTwo);
    }

    public static boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private static int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;};
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
