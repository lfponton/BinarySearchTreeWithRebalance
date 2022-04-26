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

  public boolean insert(E element) {
    if (element == null)
    {
      return false;
    }
    else if (containsElement(element)){
      return false;
    }
    else {
    root = insert(root, element);
    return true;
    }
  }

  private BinarySearchTreeNode<E> insert(BinarySearchTreeNode<E> currentNode, E element)
  {
    if (currentNode == null)
    {
      return new BinarySearchTreeNode<>(element);
    }

    int compareResult = element.compareTo(currentNode.getElement());

    if (compareResult < 0) {
      currentNode.addLeftChild(insert(currentNode.getLeftChild(), element));
    }
    else if (compareResult > 0) {
      currentNode.addRightChild(insert(currentNode.getRightChild(), element));
    }
    else {
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

  public static void main(String[] args)
  {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);
    tree.setRoot(root);
    tree.insert(2);
    tree.insert(5);
    tree.insert(1);
    tree.insert(4);


  }
}
