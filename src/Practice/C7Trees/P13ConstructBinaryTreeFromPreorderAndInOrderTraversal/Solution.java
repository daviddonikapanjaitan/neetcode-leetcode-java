package Practice.C7Trees.P13ConstructBinaryTreeFromPreorderAndInOrderTraversal;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode result = buildTree(preOrder, inOrder);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }

    public TreeNode buildTree(int[] preOrder, int[] inorder) {
        if(preOrder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preOrder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preOrder, 1, mid + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInOrder);

        int[] rightPreorder = Arrays.copyOfRange(preOrder, mid + 1, preOrder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInOrder);

        return root;
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
