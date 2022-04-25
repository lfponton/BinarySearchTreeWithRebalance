import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class BinaryTreeTest
{
  private BinaryTree<Integer> tree;

  @BeforeEach
  public void setUp() {
    tree = new BinaryTree<>();
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
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    tree.setRoot(node);
    assertEquals(element, tree.getRoot().getElement());
    assertEquals(1, tree.size());
  }

  @Test
  public void settingRootWithChildrenThrowIllegalArgumentException() {
    Integer element = 89;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(element);
    node.addLeftChild(leftChild);
    assertThrows(IllegalArgumentException.class,
        ()-> tree.setRoot(node));
  }

  @Test
  public void preOrderTraversalReturnsEmptyArrayIfTreeIsEmpty() {
    assertTrue(tree.preOrder().isEmpty());
  }

  @Test
  public void preOrderTraversalReturnsPreOrderedArrayList()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(4);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);

    List<Integer> preOrderedList = new ArrayList<>();
    for (int i = 1; i < 6; i++)
    {
      preOrderedList.add(i);
    }
    assertArrayEquals(preOrderedList.toArray(), tree.preOrder().toArray());
  }

  @Test public void inOrderTraverseReturnsEmptyArrayIfTreeIsEmpty() {
    assertTrue(tree.inOrder().isEmpty());
  }

  @Test
  public void inOrderTraversalReturnsPreOrderedArrayList()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(3);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);

    List<Integer> inOrderedList = new ArrayList<>();
    for (int i = 1; i < 6; i++)
    {
      inOrderedList.add(i);
    }
    assertArrayEquals(inOrderedList.toArray(), tree.inOrder().toArray());
  }

  @Test public void postOrderTraverseReturnsEmptyArrayIfTreeIsEmpty() {
    assertTrue(tree.postOrder().isEmpty());
  }

  @Test
  public void postOrderTraversalReturnsPreOrderedArrayList()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(2);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);

    List<Integer> postOrderedList = new ArrayList<>();
    for (int i = 1; i < 6; i++)
    {
      postOrderedList.add(i);
    }
    assertArrayEquals(postOrderedList.toArray(), tree.postOrder().toArray());
  }

  @Test
  public void heightOfEmptyTreeIsMinusOne() {
    assertEquals(-1, tree.height(tree));
  }

  @Test
  public void heightOfTreeWithOnlyRootIsZero() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    tree.setRoot(root);
    assertEquals(0, tree.height(tree));
  }

  @Test void heightOfTreeWithManyNodesGivesRightHeight()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(2);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);
    assertEquals(2, tree.height(tree));
  }

  @Test void heightOfTreeWithMoreLeftNodesGivesRightHeight()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> leftLeftLeftChild = new BinaryTreeNode<>(6);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);
    leftLeftChild.addLeftChild(leftLeftLeftChild);
    assertEquals(3, tree.height(tree));
  }

  @Test void heightOfTreeWithMoreRightNodesGivesRightHeight()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> rightRightChild = new BinaryTreeNode<>(7);
    BinaryTreeNode<Integer> rightRightRightChild = new BinaryTreeNode<>(6);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);
    rightChild.addRightChild(rightRightChild);
    rightRightChild.addRightChild(rightRightRightChild);
    assertEquals(3, tree.height(tree));
  }

  @Test void heightOfTreeWithMoreLeftRightNodesGivesRightHeight()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> rightRightLeftChild = new BinaryTreeNode<>(6);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);
    rightLeftChild.addRightChild(rightRightLeftChild);
    assertEquals(3, tree.height(tree));
  }

  @Test public void levelOrderTraverseReturnsEmptyArrayIfTreeIsEmpty() {
    assertTrue(tree.levelOrder().isEmpty());
  }

  @Test
  public void levelOrderTraversalReturnsPreOrderedArrayList()
  {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> leftLeftChild = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> rightLeftChild = new BinaryTreeNode<>(5);
    tree.setRoot(root);
    root.addLeftChild(leftChild);
    root.addRightChild(rightChild);
    leftChild.addLeftChild(leftLeftChild);
    leftChild.addRightChild(rightLeftChild);

    List<Integer> levelOrderedList = new ArrayList<>();
    for (int i = 1; i < 6; i++)
    {
      levelOrderedList.add(i);
    }
    assertArrayEquals(levelOrderedList.toArray(), tree.levelOrder().toArray());
  }
}
