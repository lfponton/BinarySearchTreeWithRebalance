import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeNodeTest
{
  @Test
  public void creatingNodeWithNullElementThrowsIllegalArgumentException()
  {
    assertThrows(IllegalArgumentException.class,
        () -> new BinarySearchTreeNode<Integer>(null));
  }

  @Test
  public void creatingNodeWithElementAddsElementToNode()
  {
    Integer element = 1;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    assertEquals(element, node.getElement());
  }

  @Test
  public void settingElementAddsTheElementToTheNode()
  {
    Integer element = 10;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer newElement = 50;
    node.setElement(newElement);
    assertEquals(newElement, node.getElement());
  }

  @Test
  public void addingLeftChildGreaterThanParentDoesNotAddLeftChild()
  {
    Integer element = 24;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer leftElement = 45;
    BinarySearchTreeNode<Integer> leftChild = new BinarySearchTreeNode<>(
        leftElement);
    node.addLeftChild(leftChild);
    assertNull(leftChild.getLeftChild());
  }

  @Test
  public void addingLeftChildLessThanParentAddsLeftChild()
  {
    Integer element = 102;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer leftElement = 74;
    BinarySearchTreeNode<Integer> leftChild = new BinarySearchTreeNode<>(
        leftElement);
    node.addLeftChild(leftChild);
    assertEquals(leftElement, node.getLeftChild().getElement());
  }

  @Test
  public void addingNewLeftChildLessThanLeftChildOfParentAddsNewLeftChildToLeftChild()
  {
    Integer element = 20;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer leftElement = 10;
    BinarySearchTreeNode<Integer> leftChild = new BinarySearchTreeNode<>(
        leftElement);
    node.addLeftChild(leftChild);
    Integer leftLeftElement = 5;
    BinarySearchTreeNode<Integer> leftLeftChild = new BinarySearchTreeNode<>(
        leftLeftElement);
    node.addLeftChild(leftLeftChild);
    assertEquals(leftLeftChild.getElement(),
        leftChild.getLeftChild().getElement());
  }

  @Test
  public void addingRightChildLessThanParentDoesNotAddRightChild()
  {
    Integer element = 39;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer rightElement = 21;
    BinarySearchTreeNode<Integer> rightChild = new BinarySearchTreeNode<>(
        rightElement);
    node.addLeftChild(rightChild);
    assertNull(rightChild.getLeftChild());
  }

  @Test
  public void addingRightChildGreaterThanParentAddsRightChild()
  {
    Integer element = 21;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer rightElement = 230;
    BinarySearchTreeNode<Integer> rightChild = new BinarySearchTreeNode<>(
        rightElement);
    node.addRightChild(rightChild);
    assertEquals(rightElement, node.getRightChild().getElement());
  }

  @Test
  public void addingNewRightChildGreaterThanRightChildOfParentAddsNewRightChildToRightChild()
  {
    Integer element = 3;
    BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(element);
    Integer rightElement = 20;
    BinarySearchTreeNode<Integer> rightChild = new BinarySearchTreeNode<>(
        rightElement);
    node.addRightChild(rightChild);
    Integer rightRightElement = 53;
    BinarySearchTreeNode<Integer> rightRightChild = new BinarySearchTreeNode<>(
        rightRightElement);
    node.addRightChild(rightRightChild);
    assertEquals(rightRightChild.getElement(),
        rightChild.getRightChild().getElement());
  }

}
