package structures.list;

import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

  private Node<E> head;
  private Node<E> tail;
  private int length = 0;

  @Override
  public int size() {
    return this.length;
  }

  @Override
  public boolean isEmpty() {
    return this.length == 0;
  }

  @Override
  public boolean contains(Object node) {
    return Objects.equals(head.item, node);
  }

  @Override
  public boolean add(E node) {
    head = new Node<>(node, null, null);
    length++;

    return true;
  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public boolean remove(Object node) {
    return false;
  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public void clear() {

  }

  @Override
  public E set(int index, E node) {
    return null;
  }

  @Override
  public void add(int index, E node) {

  }

  @Override
  public int indexOf(Object node) {
    return 0;
  }

  private class Node<V> {

    V item;
    Node<V> next;
    Node<V> prev;

    public Node(V item, Node<V> next, Node<V> prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }
}
