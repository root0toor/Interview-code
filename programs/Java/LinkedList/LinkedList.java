package LinkedList;

public class LinkedList<T> {
    ListNode<T> head;

    public void add(T val) {
        ListNode<T> node = new ListNode<>(val);
        if (head == null) {
            head = node;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void displayLinkedList() {
        ListNode<T> current = head;
        if (current == null) {
            return;
        }
        while (current != null) {
            System.out.println("The LinkedList Value is: " + current.val);
            current = current.next;
        }
        System.out.println();
    }
}

