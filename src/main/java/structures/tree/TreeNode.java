package structures.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {

        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {

        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static TreeNode prepare(int ... data) {
        TreeNode head = new TreeNode(data[0]);

        for (int i = 1; i < data.length; i++) {
            TreeNode node = new TreeNode(data[i]);
            add(head, node);
        }

        return head;
    }

    private static TreeNode add(TreeNode head, TreeNode node) {
        if (head.left == null) {
            head.left = node;
            return head;
        } else
        if (head.right == null) {
            head.right = node;
            return head;
        } else if (head.left.left == null || head.left.right == null){
            add(head.left, node);
        } else {
            add(head.right, node);
        }

        return head;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof TreeNode)) return false;

        TreeNode other = (TreeNode) obj;
        return Objects.equals(other.data, this.data)
                && Objects.equals(other.left, this.left)
                && Objects.equals(other.right, this.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            sb.append(curr.data).append(",");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
