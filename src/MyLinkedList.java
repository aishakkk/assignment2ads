public class MyLinkedList<T> implements MyList{
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    Node<T> head;
    Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        System.out.print("Linked List:  ");
        if (size == 0) {
            System.out.print("List is empty\n");
            return;
        }
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        System.out.print(head.val + " - ");
        Node<T> ptr = head.next;
        while (ptr.next != null) {
            System.out.print(ptr.val + " - ");
            ptr = ptr.next;
        }
        System.out.print(ptr.val + "\n");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (head.val == o) {
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.val == o) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public void add(Object item, int index) {

    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
