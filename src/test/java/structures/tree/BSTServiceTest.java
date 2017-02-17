package structures.tree;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
*              8
*          3       10
*       1    6   9    14
*/
public class BSTServiceTest {

    private BSTService service;
    private TreeNode head;

    @Before
    public void setUp() {
        service = new BSTService();
        head = TreeNode.prepare(new int[] {8,3,10,1,6,9,14} );
    }

    @Test
    public void inOrderTraversal() {
        service.inOrderTraversal(head);
        String actual = service.toString();

        assertThat(actual).isEqualTo("1,3,6,8,9,10,14");
    }

    @Test
    public void preOrderTraversal() {
        service.preOrderTraversal(head);
        String actual = service.toString();

        assertThat(actual).isEqualTo("8,1,3,6,9,10,14");
    }

    @Test
    public void postOrderTraversal() {
        service.postOrderTraversal(head);
        String actual = service.toString();

        assertThat(actual).isEqualTo("1,3,6,9,10,14,8");
    }

    @Test
    public void findKthSmallest() {
        TreeNode actual = service.findKthSmallest(head, 7);

        assertThat(actual.data).isEqualTo(14);
    }

    @Test
    public void findKthSmallestWhenHeadIsNull() {
        TreeNode actual = service.findKthSmallest(null, 7);

        assertThat(actual).isNull();
    }

    @Test
    public void findKthSmallestWhenKBiggerThanTreeSize() {
        TreeNode actual = service.findKthSmallest(null, 8);

        assertThat(actual).isNull();
    }
}