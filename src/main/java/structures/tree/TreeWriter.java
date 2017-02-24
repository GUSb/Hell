package structures.tree;

public interface TreeWriter {

    String serializeTree(TreeNode root);

    TreeNode restoreTree(String str);
}
