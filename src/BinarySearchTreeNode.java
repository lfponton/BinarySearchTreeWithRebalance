public class BinarySearchTreeNode<E extends Comparable<E>>
    extends BinaryTreeNode<E>
{
  private BinarySearchTreeNode<E> leftChild;
  private BinarySearchTreeNode<E> rightChild;
  private int height;

  public void setHeight(int height)
  {
    this.height = height;
  }

  public void setLeftChild(BinarySearchTreeNode<E> leftChild)
  {
    this.leftChild = leftChild;
  }

  public void setRightChild(BinarySearchTreeNode<E> rightChild)
  {
    this.rightChild = rightChild;
  }

  public BinarySearchTreeNode(E element)
  {
    super(element);
  }

  @Override public BinarySearchTreeNode<E> getLeftChild()
  {
    return leftChild;
  }

  @Override public BinarySearchTreeNode<E> getRightChild()
  {
    return rightChild;
  }

  public void addLeftChild(BinarySearchTreeNode<E> node)
  {
    if (node == null) {
      leftChild = null;
      return;
    }

    int compareResult = node.getElement().compareTo(getElement());

    if (compareResult == 0)
    {
      return;
    }
    if (compareResult < 0)
    {
      if (getLeftChild() == null)
      {
        leftChild = node;
        return;
      }
      leftChild.addLeftChild(node);
    }
  }

  public void addRightChild(BinarySearchTreeNode<E> node)
  {
    if (node == null) {
      rightChild = null;
      return;
    }

    int compareResult = node.getElement().compareTo(getElement());

    if (compareResult == 0)
    {
      return;
    }
    if (compareResult > 0)
    {
      if (getRightChild() == null)
      {
        rightChild = node;
        return;
      }
      rightChild.addRightChild(node);
    }
  }
}
