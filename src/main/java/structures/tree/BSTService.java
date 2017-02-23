package structures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTService {

    private Queue<Integer> queue = new LinkedList<>();

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        queue.add(root.data);
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        queue.add(root.data);
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        queue.add(root.data);
    }

    public TreeNode findKthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                k--;
                if (k == 0) return temp;

                root = temp.right;
            }
        }

        return null;
    }

    public void clear() {
        queue.clear();
    }

    public boolean validate(TreeNode root) {

        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;

        if (root.data < min || root.data > max) return false;

        return validate(root.left, min, root.data) && validate(root.right, root.data, max);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int num = queue.remove();

            if (queue.isEmpty())
                sb.append(num);
            else
                sb.append(num).append(",");
        }

        return sb.toString();
    }
}
