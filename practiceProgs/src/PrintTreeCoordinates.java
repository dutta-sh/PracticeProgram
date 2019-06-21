import java.util.ArrayList;
import java.util.List;

public class PrintTreeCoordinates {

    public static void main(String[] args) {
        TreeNode root = populateTree(10);
        getCoOrds(root, 0, 0);
    }

    private static TreeNode populateTree(int limit) {
        TreeNode root = new TreeNode(0);
        List<TreeNode> upper = new ArrayList<>();
        upper.add(root);
        int i = 1;

        while(i < limit) {
            List<TreeNode> lower = new ArrayList<>();
            int j = 0;
            while(i < limit && j < upper.size()) {
                TreeNode parent = upper.get(j);

                System.out.println("Creating left child of " + parent.val);
                parent.left = new TreeNode(i++);
                lower.add(parent.left);

                if(i == limit)
                    break;

                System.out.println("Creating right child of " + parent.val);
                parent.right = new TreeNode(i++);
                lower.add(parent.right);

                j++;
            }
            upper = lower;
        }
        return root;
    }

    private static void getCoOrds(TreeNode n, int x, int y) {
        if(n == null)
            return;

        System.out.println(n.val + " ::x:: " + x + " ::y:: " + y);
        getCoOrds(n.left, x-1, y-1);
        getCoOrds(n.right, x+1, y-1);
    }
}
