import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

  public int height(BinaryTree<E> tree) {
    if(tree.getRoot() == null) {
      return -1;
    }
    return heightCalculator(tree.getRoot(), 0);
  }

  private int heightCalculator(BinaryTreeNode<E> node, int height)
  {
    int leftHeight = height;
    int rightHeight = height;

    if(node.getLeftChild() != null) {
      leftHeight = heightCalculator(node.getLeftChild(), height + 1);
    }

    if(node.getRightChild() != null) {
      rightHeight = heightCalculator(node.getRightChild(), height + 1);
    }

    return Math.max(leftHeight, rightHeight);
  }

  public List<E> levelOrder()
  {
    List<E> elements = new ArrayList<>();
    Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
    queue.add(this.getRoot());
    while (!queue.isEmpty()) {
      BinaryTreeNode<E> node = queue.poll();
      visitNode(elements, node);
      if (node.getLeftChild() != null)
      {
        queue.add(node.getLeftChild());
      }
      if (node.getRightChild() != null)
      {
        queue.add(node.getRightChild());
      }
    }
    return elements;
  }

}
