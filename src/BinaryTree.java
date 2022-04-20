public class BinaryTree<E>
{
  BinaryTreeNode<E> root;
  int size;

  public BinaryTree() {

  }

  public void setRoot(BinaryTreeNode<E> root) {
    if (root.getLeftChild() == null && root.getRightChild() == null)
    {
      this.root = root;
      size++;
    }
    else
      throw new IllegalArgumentException("Cannot set a root with children");
  }

  public BinaryTreeNode<E> getRoot() {
    return root;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
