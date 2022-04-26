import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest
{
  private BinarySearchTree<Integer> tree;

  @BeforeEach
  public void setUp() {
    tree = new BinarySearchTree<>();
  }

  @Test
  public void creatingTreeSetsRootToNullAndSizeToZeroAndEmpty()
  {
    assertNull(tree.getRoot());
    assertEquals(0, tree.size());
    assertTrue(tree.isEmpty());
  }

  @Test
  public void settingRootAddsTheRootToTheTreeAndIncreasesSize() {
    Integer element = 78;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    tree.setRoot(node);
    assertEquals(element, tree.getRoot().getElement());
    assertEquals(1, tree.size());
  }

  @Test
  public void settingRootWithChildrenThrowIllegalArgumentException() {
    Integer element = 89;
    Integer element2 = 30;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    BinarySearchTreeNode<Integer> leftChild =
        new BinarySearchTreeNode<>(element2);
    node.addLeftChild(leftChild);
    assertThrows(IllegalArgumentException.class,
        ()-> tree.setRoot(node));
  }

  @Test public void inOrderTraverseReturnsEmptyArrayIfTreeIsEmpty() {
    assertTrue(tree.inOrder().isEmpty());
  }

  @Test
  public void inOrderTraversalReturnsPreOrderedArrayList()
  {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(2);
    tree.insert(5);
    tree.insert(1);
    tree.insert(4);

    List<Integer> inOrderedList = new ArrayList<>();
    inOrderedList.add(3);
    inOrderedList.add(2);
    inOrderedList.add(1);
    inOrderedList.add(4);
    inOrderedList.add(5);

    assertArrayEquals(inOrderedList.toArray(), tree.inOrder().toArray());
  }
}
