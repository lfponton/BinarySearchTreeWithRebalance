import java.util.ArrayList;
import java.util.List;

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

  public List<E> preOrder() {
    List<E> elements = new ArrayList<>();
    preOrderTraverse(elements, this.root);
    return elements;
  }

  private void preOrderTraverse(List<E> elements, BinaryTreeNode<E> node) {
    if(node == null) {
      return;
    }
    visitNode(elements, node);
    preOrderTraverse(elements, node.getLeftChild());
    preOrderTraverse(elements, node.getRightChild());
  }

  public List<E> inOrder() {
    List<E> elements = new ArrayList<>();
    inOrderTraverse(elements, this.root);
    return elements;
  }

  private void inOrderTraverse(List<E> elements, BinaryTreeNode<E> node)
  {
    if(node == null) {
      return;
    }
    inOrderTraverse(elements, node.getLeftChild());
    visitNode(elements, node);
    inOrderTraverse(elements, node.getRightChild());
  }

  public List<E> postOrder() {
    List<E> elements = new ArrayList<>();
    postOrderTraverse(elements, this.root);
    return elements;
  }

  private void postOrderTraverse(List<E> elements, BinaryTreeNode<E> node)
  {
    if(node == null) {
      return;
    }
    postOrderTraverse(elements, node.getLeftChild());
    postOrderTraverse(elements, node.getRightChild());
    visitNode(elements, node);
  }

  private void visitNode(List<E> elements, BinaryTreeNode<E> node)
  {
    elements.add(node.getElement());
  }
}
