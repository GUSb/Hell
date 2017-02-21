package structures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class StackTreeWriter implements TreeWriter {

    public String serializeTree(TreeNode root) {
        if (root == null) return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.data).append(SPLITTER);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (curr.left == null && curr.right == null) continue;

            if (curr.left == null) {
                sb.append(EMPTY).append(SPLITTER);
            } else {
                sb.append(curr.left.data).append(SPLITTER);
                queue.add(curr.left);
            }

            if (curr.right == null) {
                sb.append(EMPTY).append(SPLITTER);
            } else {
                sb.append(curr.right.data).append(SPLITTER);
                queue.add(curr.right);
            }
        }

        return sb.toString();
    }

    public TreeNode restoreTree(String str) {
        if (str == null || str.isEmpty()) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] data = str.split(SPLITTER);
        TreeNode root = new TreeNode(Integer.valueOf(data[0]), null, null);
        queue.add(root);

        for (int i = 1; i < data.length; i += 2) {
            int currDataLeft = Integer.valueOf(data[i]);
            int curDataRight = Integer.valueOf(data[i + 1]);
            TreeNode currNode = queue.remove();

            if (currDataLeft != 0) {
                TreeNode left = new TreeNode(currDataLeft, null, null);
                currNode.left = left;
                queue.add(left);
            }

            if (curDataRight != 0) {
                TreeNode right = new TreeNode(curDataRight, null, null);
                currNode.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}
