import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BinaryTreeTest
{
  private BinaryTree<Integer> tree;

  @BeforeEach
  public void setUp() {
    tree = new BinaryTree<>();
  }

  @Test
  public void CreatingTreeSetsRootToNullAndSizeToZeroAndEmpty()
  {
    assertNull(tree.getRoot());
    assertEquals(0, tree.size());
    assertTrue(tree.isEmpty());
  }

  @Test
  public void SettingRootAddsTheRootToTheTreeAndIncreasesSize() {
    Integer element = 78;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    tree.setRoot(node);
    assertEquals(element, tree.getRoot().getElement());
    assertEquals(1, tree.size());
  }

  @Test
  public void SettingRootWithChildrenThrowIllegalArgumentException() {
    Integer element = 89;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(element);
    node.addLeftChild(leftChild);
    assertThrows(IllegalArgumentException.class,
        ()-> tree.setRoot(node));
  }
}
