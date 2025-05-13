package Practice.C7Trees.P12KthSmallestElementInABst;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.left.right = new TreeNode(2);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int result = kthSmallest(root, 3);
        System.out.println(result);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp);
        return tmp[1];
    }

    private void dfs(TreeNode node, int[] tmp) {
        if(node == null) {
            return;
        }

        dfs(node.left, tmp);
        tmp[0] -= 1;
        if(tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }

        dfs(node.right, tmp);
    }

    public static class TreeNode {
        int val;
        Solution.TreeNode left;
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
