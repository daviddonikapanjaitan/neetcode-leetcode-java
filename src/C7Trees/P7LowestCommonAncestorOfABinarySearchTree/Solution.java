package C7Trees.P7LowestCommonAncestorOfABinarySearchTree;

public class Solution {

    public static void main(String[] args) {
        TreeNode rootOne = new TreeNode(6);
        rootOne.left = new TreeNode(2);
        rootOne.right = new TreeNode(8);
        rootOne.left.left = new TreeNode(0);
        rootOne.left.right = new TreeNode(4);
        rootOne.left.right.left = new TreeNode(3);
        rootOne.left.right.right = new TreeNode(5);
        rootOne.right.left = new TreeNode(7);
        rootOne.right.right = new TreeNode(9);
        TreeNode node = lowestCommonAncestor(rootOne, new TreeNode(2), new TreeNode(8));
        System.out.println(node.val);
        TreeNode node2 = lowestCommonAncestor(rootOne, new TreeNode(2), new TreeNode(4));
        System.out.println(node2.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
