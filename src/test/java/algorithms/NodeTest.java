package algorithms;

import org.junit.Test;

public class NodeTest {

    @Test
    public void testNode() {
        Node first = new Node(3);
        Node middle = new Node(5);
        Node last = new Node(7);

        first.setNext(middle);
        middle.setNext(last);

        printList(first);
    }

    private void printList(Node node) {
        while(node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}