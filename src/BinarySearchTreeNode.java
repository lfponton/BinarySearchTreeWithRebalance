public class BinarySearchTreeNode<E extends Comparable<E>>
    extends BinaryTreeNode<E>
{
  private BinarySearchTreeNode<E> leftChild;
  private BinarySearchTreeNode<E> rightChild;

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
    if (node == null || node.getElement().compareTo(getElement()) == 0)
    {
      return;
    }
    if (node.getElement().compareTo(getElement()) < 0)
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
    if (node == null || node.getElement().compareTo(getElement()) == 0)
    {
      return;
    }
    if (node.getElement().compareTo(getElement()) > 0)
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
