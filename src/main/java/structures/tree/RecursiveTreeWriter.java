package structures.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class RecursiveTreeWriter implements TreeWriter {

    private static final String SPLITTER = ",";
    private static final String EMPTY = "NULL";

    @Override
    public String serializeTree(TreeNode root) {
        if (root == null)
            return null;

        StringBuilder sb = new StringBuilder();
        serializeTreeHelper(root, sb);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    @Override
    public TreeNode restoreTree(String str) {
        if (str == null || str.isEmpty())
            return null;

        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(str.split(SPLITTER)));

        return restoreTreeHelper(nodes);
    }

    private void serializeTreeHelper(TreeNode node, StringBuilder sb) {

        if (node == null)
            sb.append(EMPTY).append(SPLITTER);
        else
            sb.append(node.data).append(SPLITTER);

        if (node != null)
            serializeTreeHelper(node.left, sb);
        if (node != null)
            serializeTreeHelper(node.right, sb);
    }

    private TreeNode restoreTreeHelper(LinkedList<String> nodes) {
        String val = nodes.remove();
        TreeNode node = null;

        if (!val.equals(EMPTY)) {
            node = new TreeNode(Integer.valueOf(val));
            node.left = restoreTreeHelper(nodes);
            node.right = restoreTreeHelper(nodes);
        }

        return node;
    }
}
