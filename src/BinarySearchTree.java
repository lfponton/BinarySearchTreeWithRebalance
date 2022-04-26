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

  // TODO: Finish
  public boolean insert(E element)
  {
    if (element == null)
    {
      return false;
    }

    BinarySearchTreeNode<E> node = new BinarySearchTreeNode<>(element);

    if (root == null)
    {
      return false;
    }
    BinarySearchTreeNode<E> currentNode = new BinarySearchTreeNode<>(element);

    int compareResult = element.compareTo(currentNode.getElement());
    while (currentNode != null)
    {

      if (compareResult < 0)
      {
        root.addLeftChild(node);
        size++;
        return true;
      }
      else if (compareResult > 0)
      {
        root.addRightChild(node);
        size++;
        return true;
      }
      else
      {
        return false;
      }
    }
    return false;
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
    tree.isEmpty();
  }
}
