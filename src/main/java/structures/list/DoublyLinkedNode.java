package structures.list;

public class DoublyLinkedNode {

  public DoublyLinkedNode next;
  public DoublyLinkedNode prev;
  int data;

  public DoublyLinkedNode(int data) {
    this.data = data;
  }

  public static DoublyLinkedNode prepare() {

    DoublyLinkedNode one = new DoublyLinkedNode(1);
    DoublyLinkedNode two = new DoublyLinkedNode(2);
    DoublyLinkedNode three = new DoublyLinkedNode(3);

    one.next = two;
    two.next = three;
    two.prev = one;
    three.prev = two;

    return one;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append(data).append(" ");
    DoublyLinkedNode curr = this.next;
    while (curr != null) {
      sb.append(curr.data).append(" ");
      curr = curr.next;
    }

    return sb.toString();
  }
}
