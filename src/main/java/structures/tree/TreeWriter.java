package structures.tree;

public interface TreeWriter {

    String SPLITTER = ",";
    String EMPTY = "NULL";

    String serializeTree(TreeNode root);

    TreeNode restoreTree(String str);
}
