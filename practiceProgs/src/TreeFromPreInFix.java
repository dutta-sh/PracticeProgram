
public class TreeFromPreInFix {
    private static int[] pre = new int[]{1,2,3,4,5};
    private static int[] in = new int[]{2, 1, 4, 3, 5};
    private static int preIdx = 0;


    private static int findInIdx(int l, int r, int val) {
        for(int i = l; i <= r; i++) {
            if(in[i] == val)
                return i;
        }
        return -1;
    }

    private static TreeNode build(int l, int r) {
        if(l > r)
            return null;

        int val = pre[preIdx++];
        TreeNode n = new TreeNode(val);
        if(l == r)
            return n;

        int inIdx = findInIdx(l, r, val);
        n.left = build(l, inIdx - 1);
        n.right = build(inIdx + 1, r);

        return n;
    }

    private static void printPreOrder(TreeNode n) {
        if(n == null)
            return;

        System.out.print(n.val + " ");
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    private static void printInOrder(TreeNode n) {
        if(n == null)
            return;

        printInOrder(n.left);
        System.out.print(n.val + " ");
        printInOrder(n.right);
    }

    public static void main(String[] args) {
        TreeNode root = build(0, pre.length - 1);

        printPreOrder(root);
        System.out.println();

        printInOrder(root);
        System.out.println();
    }
}
