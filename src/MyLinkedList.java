public class MyLinkedList<T> implements MyList{
    /**
     * every element is Node which have 3 parameters - value of element, reference to next and previous elements
     */
    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;
        /**
         * @function Node - constructor to create Node with given item
         * @param val - given element to create node
         * @param next - reference to next Node
         * @param prev - reference to previous Node
         */
        Node(T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    Node<T> head; // start of the list
    Node<T> tail; // end of the list
    private int size;
    /**
     * @function MyLinkedList - constructor that creating new linked list
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /**
     * @function isEmpty - function check is linked list empty or not
     * @return boolean - true if list empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * @function display - function print all elements of linked list in console
     */
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
    /**
     * @function size - function returns size of linked list
     * @return int - size of list
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * @function contains - function check is list have given element
     * @param o - given element to check
     * @return boolean - true if linked list contains given item, false otherwise
     */
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
    /**
     * @function add - function add element to linked list at end
     * @param item - given element to add
     */
    @Override
    public void add(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    /**
     * @function add - function add element to linked list at specific index
     * @param item - given element to add
     * @param index - given index where we add element
     */
    @Override
    public void add(Object item, int index) {
        checkIndex(index); // checking if given index acceptable
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        Node<T> ptr = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                Node<T> temp = ptr.next;
                ptr.next = newNode;
                newNode.prev = ptr;
                newNode.next = temp;
                temp.prev = newNode;
            }
            ptr = ptr.next;
        }
        size++;
    }
    /**
     * @function remove - function delete element in linked list
     * @param item - given element to delete
     * @return boolean - true if successfully remove element, false otherwise
     */
    @Override
    public boolean remove(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head.val == newNode.val) { // checking if element contains in linked list
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.val == newNode.val) { // checking if element contains in linked list
                Node<T> temp = ptr.prev;
                temp.next = ptr.next;
                Node<T> temp2 = ptr.next;
                temp2.prev = temp;
                size--;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    /**
     * @function remove - function delete element at specific index
     * @param index - given index of element to delete
     * @return Object - deleted element
     */
    @Override
    public Object remove(int index) {
        checkIndex(index); // checking if given index acceptable
        if (index == 0) {
            Object removed = head.val;
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return removed;
            }
            head = head.next;
            head.prev = null;
            size--;
            return removed;
        }
        if (index == size-1) {
            Object removed = tail.val;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                Node<T> p = ptr.prev;
                Node<T> n = ptr.next;
                Object removed = ptr.val;

                p.next = n;
                n.prev = p;
                size--;
                return removed;
            }
            ptr = ptr.next;
        }
        return null;
    }
    /**
     * @function clear - function clear all linked list by creating new
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    /**
     * @function get - function returns element in linked list by specific index
     * @param index - given index of element to get
     * @return Object - founded element by index
     */
    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.val;
        }
        Node<T> newNode = head.next;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                return newNode.val;
            }
            newNode = newNode.next;
        }
        return null;
    }
    /**
     * @function indexOf - function returns index of given element in linked list
     * @param o - given element to find
     * @return int - index of element
     */
    @Override
    public int indexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (head.val == newNode.val) {
            return 0;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (ptr.val == newNode.val) {
                return i;
            }
            ptr = ptr.next;
        }
        return -1;
    }
    /**
     * @function lastIndexOf - function returns last index of given element in linked list
     * @param o - given element to find
     * @return int - index of element
     */
    @Override
    public int lastIndexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (tail.val == newNode.val) {
            return size-1;
        }
        Node<T> ptr = tail.prev;
        for (int i = size-1; i >= 1; i--) {
            if (ptr.val == newNode.val) {
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }

    @Override
    public void sort() {

    }
    /**
     * @function checkIndex - function checks given index, throw error if index not acceptable
     * @param index - given index to check
     */
    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public void sublist {

    }
}
