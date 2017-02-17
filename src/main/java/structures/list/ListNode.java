package structures.list;

public class ListNode {

    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode deleteAtTail(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public static ListNode prepare() {
        ListNode node = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        four.next = five;
        three.next = four;
        two.next = three;
        node.next = two;
        return node;
    }

    public static ListNode prepareCycle() {
        ListNode node = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        three.next = four;
        two.next = three;
        node.next = two;
        four.next = node;
        return node;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(data).append(" ");
        ListNode curr = this.next;
        while (curr != null) {
            sb.append(curr.data).append(" ");
            curr = curr.next;
        }

        return sb.toString();
    }
}
