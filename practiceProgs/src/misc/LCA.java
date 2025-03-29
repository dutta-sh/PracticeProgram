package misc;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    List<TNode> list1 = new ArrayList<>();
    List<TNode> list2 = new ArrayList<>();

    public void traverse(int val, TNode n, List<TNode> list) {
        if(val == n.val) {
            list.add(n);
            return;
        }

        traverse(val, n.left, list);
        traverse(val, n.right, list);

        list.remove(n);
    }
}

class TNode {
    int val;
    TNode left;
    TNode right;

    public TNode (int val) {
        this.val = val;
    }
}