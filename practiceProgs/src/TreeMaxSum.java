public class TreeMaxSum {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        recur(root);
    }

    private static int recur(TreeNode n) {
        if(n == null) {
            maxSum = Math.max(0, maxSum);
            return 0;
        }

        if(n.left == null && n.right == null) {
            maxSum = Math.max(n.val, maxSum);
            return n.val;
        }

        int mySum = n.val + Math.max(recur(n.left), recur(n.right));
        maxSum = Math.max(mySum, maxSum);

        return mySum;
    }
}
