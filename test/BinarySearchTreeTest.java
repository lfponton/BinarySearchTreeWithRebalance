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
    inOrderedList.add(1);
    inOrderedList.add(2);
    inOrderedList.add(3);
    inOrderedList.add(4);
    inOrderedList.add(5);

    assertArrayEquals(inOrderedList.toArray(), tree.inOrder().toArray());
  }

  @Test
  public void insertingInEmptyTreeReturnsTrue() {
    assertTrue(tree.insert(2));
  }

  @Test
  public void insertingNullElementReturnsFalse() {
    assertFalse(tree.insert(null));
  }

  @Test
  public void checkingIfATreeContainsAndElementThatDoestNotContainReturnsFalse() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(2);
    tree.insert(5);
    tree.insert(1);
    tree.insert(4);
    assertFalse(tree.containsElement(10));
  }
  @Test
  public void insertingElementAlreadyContainedInTreeReturnsFalse() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(2);
    assertFalse(tree.insert(2));
  }

  @Test
  public void insertingElementIntoTreeReturnsTrue() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    assertTrue(tree.insert(12));
  }

  @Test
  public void findingMinInEmptyTreeReturnsNull() {
    assertNull(tree.findMin());
  }
  @Test
  public void findingMinReturnsNodeWithSmallestElement() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(2);
    tree.insert(5);
    tree.insert(1);
    tree.insert(4);
    assertEquals(1, tree.findMin().getElement());
  }

  @Test
  public void findingMaxInEmptyTreeReturnsNull() {
    assertNull(tree.findMax());
  }

  @Test
  public void findingMaxReturnsNodeWithLargestElement() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(2);
    tree.insert(5);
    tree.insert(1);
    tree.insert(4);
    assertEquals(5, tree.findMax().getElement());
  }

  @Test
  public void removingNullElementReturnsFalse() {
    assertFalse(tree.removeElement(null));
  }
  @Test
  public void removingElementNotInTheTreeReturnsFalse() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(1);
    assertFalse(tree.removeElement(2));
  }
  @Test
  public void removingElementRemovesElementFromTree() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(6);
    tree.setRoot(root);
    tree.insert(4);
    tree.insert(8);
    tree.insert(3);
    tree.insert(5);
    tree.insert(7);
    tree.insert(9);
    assertTrue(tree.containsElement(9));
    tree.removeElement(9);
    assertFalse(tree.containsElement(9));
  }

  @Test
  public void removingElementWithChildrenRemovesElementAndReplacesWithRightChild() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(6);
    tree.setRoot(root);
    tree.insert(4);
    tree.insert(8);
    tree.insert(3);
    tree.insert(5);
    tree.insert(7);
    tree.insert(9);
    assertTrue(tree.containsElement(8));
    tree.removeElement(8);
    assertFalse(tree.containsElement(8));
  }

  @Test
  public void removingElementWithOneChildRemovesElementAndReplacesWithChild() {
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(6);
    tree.setRoot(root);
    tree.insert(4);
    tree.insert(8);
    tree.insert(3);
    tree.insert(5);
    tree.insert(7);
    assertTrue(tree.containsElement(8));
    tree.removeElement(8);
    assertFalse(tree.containsElement(8));
  }

  @Test
  public void reBalancingUnbalancedTreeBalancesTree() {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.setRoot(new BinarySearchTreeNode<Integer>(6));
    tree.getRoot().setLeftChild(new BinarySearchTreeNode<Integer>(1));
    tree.getRoot().setRightChild(new BinarySearchTreeNode<Integer>(7));
    tree.getRoot().getRightChild().setRightChild(new BinarySearchTreeNode<Integer>(8));
    tree.getRoot().getRightChild().setLeftChild(new BinarySearchTreeNode<Integer>(2));
    tree.getRoot().getRightChild().getRightChild().setRightChild(new BinarySearchTreeNode<Integer>(9));
    tree.getRoot().getRightChild().getRightChild().setLeftChild(new BinarySearchTreeNode<Integer>(3));
    tree.reBalance();
    assertEquals(7, tree.getRoot().getElement());
  }

}
