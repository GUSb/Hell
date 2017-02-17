package structures.tree;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeNodeTest {



    @Test
    public void prepareOneFullEdge() {
        int[] data = new int[] {1,2,3};

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(3);

        TreeNode actual = TreeNode.prepare(data);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void prepareRootWithEmptyLeafs() {
        int[] data = new int[] {1};

        TreeNode expected = new TreeNode(1);

        TreeNode actual = TreeNode.prepare(data);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Ignore("The unbalanced tree for prepare method is not working yet")
    public void prepareUnbalancedTree() {
        /*
        *     1
        *   2   3
        * 4       7
        *
        * */
        int[] data = new int[] {1,2,3,4,0,0,7};

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(3);
        expected.left.left = new TreeNode(4);
        expected.right.right = new TreeNode(7);

        TreeNode actual = TreeNode.prepare(data);

        assertThat(actual).isEqualTo(expected);
    }
}