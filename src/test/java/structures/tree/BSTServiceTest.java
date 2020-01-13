package structures.tree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 8 3       10 1    6   9    14
 */
public class BSTServiceTest {

  private BSTService service;
  private TreeNode head;

  @Before
  public void setUp() {
    service = new BSTService();
    head = TreeNode.prepare(8, 3, 10, 1, 6, 9, 14);
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

  @Test
  public void validateWhenOneNode() {
    TreeNode root = new TreeNode(20, null, null);

    boolean result = service.validate(root);

    Assert.assertTrue(result);
  }

  @Test
  public void validateWhenLeftChildNodeIsLessThanParent() throws Exception {
    TreeNode left = new TreeNode(10, null, null);
    TreeNode root = new TreeNode(20, left, null);

    boolean result = service.validate(root);

    Assert.assertTrue(result);
  }

  @Test
  public void validateWhenLeftChildNodeIsGreaterThanParent() throws Exception {
    TreeNode left = new TreeNode(30, null, null);
    TreeNode root = new TreeNode(20, left, null);

    boolean result = service.validate(root);

    Assert.assertFalse(result);
  }

  @Test
  public void validateWhenRightChildNodeIsLessThanParent() throws Exception {
    TreeNode right = new TreeNode(10, null, null);
    TreeNode root = new TreeNode(20, null, right);

    boolean result = service.validate(root);

    Assert.assertFalse(result);
  }

  @Test
  public void validateWhenRightChildNodeIsGreaterThanParent() throws Exception {
    TreeNode right = new TreeNode(30, null, null);
    TreeNode root = new TreeNode(20, null, right);

    boolean result = service.validate(root);

    Assert.assertTrue(result);
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Test
  public void validateWhenLeftSubChildLessThanParents() throws Exception {
    TreeNode left_left = new TreeNode(5, null, null);
    TreeNode left = new TreeNode(10, left_left, null);
    TreeNode root = new TreeNode(20, left, null);

    boolean result = service.validate(root);

    Assert.assertTrue(result);
  }

  @Test
  public void validateWhenLeftSubChildGreaterThanNearestParent() throws Exception {
    TreeNode left_left = new TreeNode(15, null, null);
    TreeNode left = new TreeNode(10, left_left, null);
    TreeNode root = new TreeNode(20, left, null);

    boolean result = service.validate(root);

    Assert.assertFalse(result);
  }

  @Test
  public void validateWhenLeftChildRightSubChildGreaterThanParents() throws Exception {
    TreeNode left_right = new TreeNode(30, null, null);
    TreeNode left = new TreeNode(10, null, left_right);
    TreeNode root = new TreeNode(20, left, null);

    boolean result = service.validate(root);

    Assert.assertFalse(result);
  }

  @Test
  public void validateWhenLeftChildRightSubChildGreaterThanNearestParentButLessThanAllHigher()
      throws Exception {
    TreeNode left_right = new TreeNode(15, null, null);
    TreeNode left = new TreeNode(10, null, left_right);
    TreeNode root = new TreeNode(20, left, null);

    boolean result = service.validate(root);

    Assert.assertTrue(result);
  }
}