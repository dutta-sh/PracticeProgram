package misc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LCABST {

    public static TreeNode getLCA(TreeNode root, int v1, int v2) {
        if(v1 < root.val && v2 > root.val)
            return root;

        if(v1 < root.val && v2 < root.val)
            return getLCA(root.left, v1, v2);

        if(v1 > root.val && v2 > root.val)
            return getLCA(root.right, v1, v2);

        return null;
    }

    Map<String, String> map = new LinkedHashMap<>();
}


