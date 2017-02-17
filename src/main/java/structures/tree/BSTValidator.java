package structures.tree;

public class BSTValidator {

    public boolean validate(TreeNode root) {

        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;

        if (root.data < min || root.data > max) return false;

        return validate(root.left, min, root.data) && validate(root.right, root.data, max);
    }
}
