package Practice.C7Trees.P14BinaryTreeMaximumPathSum;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        TreeNode nodeOne = new TreeNode(1);
        nodeOne.left = new TreeNode(2);
        nodeOne.right = new TreeNode(3);

        TreeNode nodeTwo = new TreeNode(-10);
        nodeTwo.left = new TreeNode(9);
        nodeTwo.right = new TreeNode(20);
        nodeTwo.right.left = new TreeNode(15);
        nodeTwo.right.right = new TreeNode(7);

        int resultOne = maxPathSum(nodeOne);
        System.out.println("Result one: " + resultOne);

        int resultTwo = maxPathSum(nodeTwo);
        System.out.println("Result two: " + resultTwo);
    }

    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{root.val};
        dfs(root, res);
        return  res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if(root == null) {
            return 0;
        }

        int leftMax = Math.max(dfs(root.left, res), 0);
        int rightMax = Math.max(dfs(root.right, res), 0);

        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
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
