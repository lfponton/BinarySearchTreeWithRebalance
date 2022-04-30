import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>
{
  private BinarySearchTreeNode<E> root;

  public BinarySearchTree()
  {
  }

  public void setRoot(BinarySearchTreeNode<E> root)
  {
    if (root.getLeftChild() == null && root.getRightChild() == null)
    {
      this.root = root;
      size++;
    }
    else
      throw new IllegalArgumentException("Cannot set a root with children");
  }

  public BinarySearchTreeNode<E> getRoot()
  {
    return root;
  }

  public boolean insert(E element)
  {
    if (element == null)
    {
      return false;
    }
    else if (containsElement(element))
    {
      return false;
    }
    else
    {
      root = insert(root, element);
      return true;
    }
  }

  private BinarySearchTreeNode<E> insert(BinarySearchTreeNode<E> currentNode,
      E element)
  {
    if (currentNode == null)
    {
      return new BinarySearchTreeNode<>(element);
    }

    int compareResult = element.compareTo(currentNode.getElement());

    if (compareResult < 0)
    {
      currentNode.addLeftChild(insert(currentNode.getLeftChild(), element));
    }
    else if (compareResult > 0)
    {
      currentNode.addRightChild(insert(currentNode.getRightChild(), element));
    }
    else
    {
      return currentNode;
    }
    return currentNode;
  }

  public boolean containsElement(E element)
  {
    List<E> elements = inOrder();
    return elements.contains(element);
  }

  public List<E> inOrder()
  {
    List<E> elements = new ArrayList<>();
    inOrderTraverse(elements, root);
    return elements;
  }

  private void inOrderTraverse(List<E> elements, BinarySearchTreeNode<E> node)
  {
    if (node == null)
    {
      return;
    }
    inOrderTraverse(elements, node.getLeftChild());
    visitNode(elements, node);
    inOrderTraverse(elements, node.getRightChild());
  }

  private void visitNode(List<E> elements, BinarySearchTreeNode<E> node)
  {
    elements.add(node.getElement());
  }

  public BinarySearchTreeNode<E> findMin()
  {
    return findMin(root);
  }

  private BinarySearchTreeNode<E> findMin(BinarySearchTreeNode<E> node)
  {
    if (node == null)
      return null;
    return node.getLeftChild() == null ? node : findMin(node.getLeftChild());
  }

  public BinarySearchTreeNode<E> findMax()
  {
    return finMax(root);
  }

  private BinarySearchTreeNode<E> finMax(BinarySearchTreeNode<E> node)
  {
    if (node == null)
      return null;
    return node.getRightChild() == null ? node : finMax(node.getRightChild());
  }

  public boolean removeElement(E element)
  {
    if (element == null)
    {
      return false;
    }
    else if (!containsElement(element))
    {
      return false;
    }
    else
    {
      root = removeElement(root, element);
      return true;
    }
  }

  private BinarySearchTreeNode<E> removeElement(
      BinarySearchTreeNode<E> currentNode, E element)
  {
    if (currentNode == null)
    {
      return null;
    }

    int compareResult = element.compareTo(currentNode.getElement());

    if (compareResult == 0)
    {
      return removeFoundElement(currentNode, element);
    }
    if (compareResult < 0)
    {
      currentNode.setLeftChild(
          removeElement(currentNode.getLeftChild(), element));
      return currentNode;
    }
    currentNode.setRightChild(
        removeElement(currentNode.getRightChild(), element));
    return currentNode;
  }

  private BinarySearchTreeNode<E> removeFoundElement(
      BinarySearchTreeNode<E> node, E element)
  {
    BinarySearchTreeNode<E> leftNode = node.getLeftChild();
    BinarySearchTreeNode<E> rightNode = node.getRightChild();

    // If both children are null, replace the node to be removed with null.
    if (leftNode == null && rightNode == null)
    {
      return null;
    }
    // If only one child is null, replace node with child
    if (leftNode == null)
    {
      return rightNode;
    }
    if (rightNode == null)
    {
      return leftNode;
    }
    // If node has two children, find child that will replace node and replace
    E minElement = findMinFromNode(rightNode);
    node.setElement(minElement);
    node.setRightChild(removeElement(node.getRightChild(), minElement));
    return node;
  }

  private E findMinFromNode(BinarySearchTreeNode<E> node)
  {
    return node.getLeftChild() == null ?
        node.getElement() :
        findMinFromNode(node.getLeftChild());
  }

  public void reBalance()
  {
    if (root == null)
    {
      return;
    }
    root = reBalance(root);
  }

  private BinarySearchTreeNode<E> reBalance(BinarySearchTreeNode<E> node)
  {
    updateHeight(node);
    int balance = getBalance(node);
    if (balance > 1)
    {
      if (heightCalculator(node.getRightChild().getRightChild(), 0)
          <= heightCalculator(node.getRightChild().getLeftChild(), 0))
      {
        node.setRightChild(rotateRight(node.getRightChild()));
      }
      node = rotateLeft(node);
    }
    else if (balance < -1)
    {
      if (heightCalculator(node.getLeftChild().getLeftChild(), 0)
          <= heightCalculator(node.getLeftChild().getRightChild(), 0))
      {
        node.setLeftChild(rotateLeft(node.getLeftChild()));
      }
      node = rotateRight(node);
    }

    return node;
  }

  private BinarySearchTreeNode<E> rotateLeft(BinarySearchTreeNode<E> node)
  {
    BinarySearchTreeNode<E> right = node.getRightChild();
    BinarySearchTreeNode<E> left = right.getLeftChild();
    right.setLeftChild(node);
    node.setRightChild(left);
    updateHeight(node);
    updateHeight(right);
    return right;
  }

  private BinarySearchTreeNode<E> rotateRight(BinarySearchTreeNode<E> node)
  {
    BinarySearchTreeNode<E> left = node.getLeftChild();
    BinarySearchTreeNode<E> right = left.getRightChild();
    left.setRightChild(node);
    node.setLeftChild(right);
    updateHeight(node);
    updateHeight(left);
    return left;
  }

  private void updateHeight(BinarySearchTreeNode<E> node)
  {
    if (node != null)
    {
      node.setHeight(heightCalculator(node, 0));
    }
  }

  private int getBalance(BinaryTreeNode<E> node)
  {
    return (node == null) ?
        0 :
        heightCalculator(node.getRightChild(), 0) - heightCalculator(
            node.getLeftChild(), 0);
  }

  public int height()
  {
    if(root == null) {
      return -1;
    }
    return heightCalculator(root, 0);
  }

  public int heightCalculator(BinarySearchTreeNode<E> node, int height)
  {
    if (node == null)
    {
      return height;
    }
    int leftHeight = height;
    int rightHeight = height;

    if (node.getLeftChild() != null) {
      leftHeight = heightCalculator(node.getLeftChild(), height + 1);
    }

    if(node.getRightChild() != null) {
      rightHeight = heightCalculator(node.getRightChild(), height + 1);
    }

    return Math.max(leftHeight, rightHeight);
  }
}
