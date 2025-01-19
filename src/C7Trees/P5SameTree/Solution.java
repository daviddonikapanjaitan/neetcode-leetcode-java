package C7Trees.P5SameTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode nodeOne = new TreeNode(1);
        nodeOne.left = new TreeNode(2);
        nodeOne.right = new TreeNode(3);
        TreeNode nodeTwo = new TreeNode(1);
        nodeTwo.left = new TreeNode(2);
        nodeTwo.right = new TreeNode(3);
        boolean result = isSameTree(nodeOne, nodeTwo);
        System.out.println(result);

        TreeNode nodeThree = new TreeNode(1);
        nodeThree.left = new TreeNode(2);
        TreeNode nodeFour = new TreeNode(1);
        nodeFour.right = new TreeNode(2);
        boolean resultTwo = isSameTree(nodeThree, nodeFour);
        System.out.println(resultTwo);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
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
