import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeNodeTest
{
  @Test
  public void creatingNodeWithNullElementThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class,
        () -> new BinaryTreeNode<Integer>(null));
  }

  @Test
  public void creatingNodeWithElementAddsElementToNode()
  {
    Integer element = 1;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    assertEquals(element, node.getElement());
  }

  @Test
  public void settingElementAddsTheElementToTheNode()
  {
    Integer element = 10;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    Integer newElement = 50;
    node.setElement(newElement);
    assertEquals(newElement, node.getElement());
  }

  @Test
  public void addingLeftChildAddsLeftChildToNode() {
    Integer element = 24;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    Integer leftElement = 45;
    BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftElement);
    node.addLeftChild(leftChild);
    assertEquals(leftChild.getElement(), node.getLeftChild().getElement());
  }

  @Test
  public void addingRightChildAddsRightChildToNode() {
    Integer element = 80;
    BinaryTreeNode<Integer> node = new BinaryTreeNode<>(element);
    Integer rightElement = 32;
    BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightElement);
    node.addRightChild(rightChild);
    assertEquals(rightChild.getElement(), node.getRightChild().getElement());
  }
}
