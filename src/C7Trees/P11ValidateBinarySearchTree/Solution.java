package C7Trees.P11ValidateBinarySearchTree;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean result = isValidBST(root);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode node, long left, long right) {
        if(node == null) {
            return true;
        }
        if(!(left < node.val && node.val < right)) {
           return false;
        }

        return valid(node.left, left, node.val) &&
                valid(node.right, node.val, right);
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
