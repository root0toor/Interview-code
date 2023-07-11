package LinkedList;

public class Main {
    public <T extends Comparable<T>> ListNode<T> mergeTwoLists(ListNode<T> node1, ListNode<T> node2) {
        ListNode<T> loutput = new ListNode<>();
        ListNode<T> tail = loutput;
        while (node1 != null && node2 != null) {
            if (node1.val.compareTo(node2.val) < 0) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        if (node1 != null) {
            tail.next = node1;
        } else if (node2 != null) {
            tail.next = node2;
        }
        displayList(loutput.next);
        return loutput.next;
    }

    public <T> void displayList(ListNode<T> current) {
        if (current == null) {
            return;
        }
        while (current != null) {
            System.out.println("The LinkedList Value is: " + current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l1.displayLinkedList();

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(3);
        l2.add(4);
        l2.displayLinkedList();

        ListNode<Integer> temp = main.mergeTwoLists(l1.head, l2.head);
    }
}


