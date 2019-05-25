import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest {

    public int countNodes(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        int levels = 0;

        if(root == null)
            return levels;

        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode n = nodes.poll();
            levels++;
            //if(n.right != null)
            //    levels++;

            if(n.left != null)
                nodes.add(n.left);

            if(n.right != null)
                nodes.add(n.right);

        }
        return levels;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}
