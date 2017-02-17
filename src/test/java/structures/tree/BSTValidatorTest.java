package structures.tree;

import structures.tree.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structures.tree.BSTValidator;

public class BSTValidatorTest {

    private BSTValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new BSTValidator();
    }

    @Test
    public void validateWhenOneNode() {
        TreeNode root = new TreeNode(20, null, null);

        boolean result = validator.validate(root);

        Assert.assertTrue(result);
    }

    @Test
    public void validateWhenLeftChildNodeIsLessThanParent() throws Exception {
        TreeNode left = new TreeNode(10, null, null);
        TreeNode root = new TreeNode(20, left, null);

        boolean result = validator.validate(root);

        Assert.assertTrue(result);
    }

    @Test
    public void validateWhenLeftChildNodeIsGreaterThanParent() throws Exception {
        TreeNode left = new TreeNode(30, null, null);
        TreeNode root = new TreeNode(20, left, null);

        boolean result = validator.validate(root);

        Assert.assertFalse(result);
    }

    @Test
    public void validateWhenRightChildNodeIsLessThanParent() throws Exception {
        TreeNode right = new TreeNode(10, null, null);
        TreeNode root = new TreeNode(20, null, right);

        boolean result = validator.validate(root);

        Assert.assertFalse(result);
    }

    @Test
    public void validateWhenRightChildNodeIsGreaterThanParent() throws Exception {
        TreeNode right = new TreeNode(30, null, null);
        TreeNode root = new TreeNode(20, null, right);

        boolean result = validator.validate(root);

        Assert.assertTrue(result);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void validateWhenLeftSubChildLessThanParents() throws Exception {
        TreeNode left_left = new TreeNode(5, null, null);
        TreeNode left = new TreeNode(10, left_left, null);
        TreeNode root = new TreeNode(20, left, null);

        boolean result = validator.validate(root);

        Assert.assertTrue(result);
    }

    @Test
    public void validateWhenLeftSubChildGreaterThanNearestParent() throws Exception {
        TreeNode left_left = new TreeNode(15, null, null);
        TreeNode left = new TreeNode(10, left_left, null);
        TreeNode root = new TreeNode(20, left, null);

        boolean result = validator.validate(root);

        Assert.assertFalse(result);
    }

    @Test
    public void validateWhenLeftChildRightSubChildGreaterThanParents() throws Exception {
        TreeNode left_right = new TreeNode(30, null, null);
        TreeNode left = new TreeNode(10, null, left_right);
        TreeNode root = new TreeNode(20, left, null);

        boolean result = validator.validate(root);

        Assert.assertFalse(result);
    }

    @Test
    public void validateWhenLeftChildRightSubChildGreaterThanNearestParentButLessThanAllHigher() throws Exception {
        TreeNode left_right = new TreeNode(15, null, null);
        TreeNode left = new TreeNode(10, null, left_right);
        TreeNode root = new TreeNode(20, left, null);

        boolean result = validator.validate(root);

        Assert.assertTrue(result);
    }
}
