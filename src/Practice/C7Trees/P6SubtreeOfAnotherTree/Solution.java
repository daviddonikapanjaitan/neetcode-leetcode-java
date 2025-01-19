package Practice.C7Trees.P6SubtreeOfAnotherTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode rootOne = new TreeNode(3);
        rootOne.left = new TreeNode(4);
        rootOne.right = new TreeNode(5);
        rootOne.left.left = new TreeNode(1);
        rootOne.left.right = new TreeNode(2);
        TreeNode subRootOne = new TreeNode(4);
        subRootOne.left = new TreeNode(1);
        subRootOne.right = new TreeNode(2);
        boolean resultOne = isSubTree(rootOne, subRootOne);
        System.out.println(resultOne);

        TreeNode rootTwo = new TreeNode(3);
        rootTwo.left = new TreeNode(4);
        rootOne.right = new TreeNode(5);
        rootTwo.left.left = new TreeNode(1);
        rootTwo.left.right = new TreeNode(2);
        rootTwo.left.right.left = new TreeNode(0);
        TreeNode subRootTwo = new TreeNode(4);
        subRootTwo.left = new TreeNode(1);
        subRootTwo.right = new TreeNode(2);
        boolean resultTwo = isSubTree(rootTwo, subRootTwo);
        System.out.println(resultTwo);
    }

    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(sameTree(root, subRoot)) {
            return true;
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static boolean sameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root != null && subRoot != null && root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }

        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
