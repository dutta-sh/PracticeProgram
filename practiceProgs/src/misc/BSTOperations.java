package misc;

public class BSTOperations {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("isBST: " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("largest: " + getLargest(root).val);
        System.out.println("smallest: " + getSmallest(root).val);

        System.out.println("2nd largest: " + getSecLargest(root, root.left, root.right).val);
        System.out.println("2nd smallest: " + getSecSmallest(root, root.left, root.right).val);
    }

    private static boolean isBST(TreeNode n, int l, int r) {
        if(n == null)
            return true;

        if(n.val > l && n.val < r)
            return isBST(n.left, l, n.val) && isBST(n.right, n.val, r);

        return false;

    }

    private static TreeNode getLargest(TreeNode n) {
        if(n.right == null)
            return n;

        return getLargest(n.right);
    }

    private static TreeNode getSmallest(TreeNode n) {
        if(n.left == null)
            return n;

        return getSmallest(n.left);
    }

    private static TreeNode getSecLargest(TreeNode n, TreeNode l, TreeNode r) {
        if(r != null) {
            if(r.left == null && r.right == null)
                return n;
            else
                return getSecLargest(r, r.left, r.right);
        }
        if(l != null) {
            if(l.left == null && l.right == null)
                return l;
            return getSecLargest(l, l.left, l.right);
        }
        return null;
    }

    private static TreeNode getSecSmallest(TreeNode n, TreeNode l, TreeNode r) {
        if(l != null) {
            if(l.left == null && l.right == null)
                return n;
            else
                return getSecSmallest(l, l.left, l.right);
        }
        if(r != null) {
            if(r.left == null && r.right == null)
                return r;
            else
                return getSecSmallest(r, r.left, r.right);
        }
        return null;
    }
}
