public class MyArrayList<T> implements MyList{
    private T[] arr; // array with generic type that can be store any types of value
    private int size; // size of array
    /**
     * @function MyArrayList - constructor to create ArrayList
     */
    public MyArrayList() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function display - function print elements of array in console
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    /**
     * @function increaseLen - function increase size of array
     */
    private void increaseLen() {
        T[] newArr = (T[]) new Object[arr.length*2]; // doubling allocated space of array  to contain more values
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // save exist values
        }
        arr = newArr;
    }
    /**
     * @function size - function returns size of array as integer
     * @return int - size of array
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * @function contains - function check is array have given element or not
     * @param o - given object to check
     * @return boolean - true if array contains given object, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {  // checking is given element equal to elements of array
                return true;
            }
        }
        return false;
    }
    /**
     * @function add - function adding a new element to array at the end
     * @param item - given object to add
     */
    @Override
    public void add(Object item) {
        if (size == arr.length){  // checking is array have enough space to add new value
            increaseLen(); // increase space of array if not
        }
        arr[size++] = (T) item;
    }
    /**
     * @function add - function adding a new element to specific index in array
     * @param item - given object to add
     * @param index - where to add item
     */
    @Override
    public void add(Object item, int index) {
        checkIndex(index); // checking is index acceptable
        if (size == arr.length) { // checking is array have enough space to add new value
            increaseLen(); // increase space of array if not
        }
        T[] newArr = (T[]) new Object[arr.length]; // creating new array to swap elements to add new between them
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int i = index; i < size; i++) {
            newArr[i+1] = arr[i];
        }
        newArr[index] = (T) item;
        arr = newArr;
        size++;
    }
    /**
     * @function remove - function remove item from array
     * @param item - given item to remove
     * @return boolean - true if item has removed, false otherwise
     */
    @Override
    public boolean remove(Object item) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) { // checking if given item contains in array and remove it after
                remove(i);
                removed = true;
            }
        }
        return removed;
    }
    /**
     * @function remove - function remove item from array in specific index and return item which was removed
     * @param index - given index of the element to remove
     * @return Object - removed element from array
     */
    @Override
    public Object remove(int index) {
        checkIndex(index); // checking if given index acceptable
        T removed = arr[index]; // store removed item to return after
        for(int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i]; // swap elements to remove element
        }
        size--;
        return removed;
    }
    /**
     * @function clear - function clear array by creating new empty array
     */
    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }
    /**
     * @function get - function returns element from array in specific index
     * @param index - given index of element to get
     * @return Object - element at given index
     */
    @Override
    public Object get(int index) {
        checkIndex(index); // checking if given index acceptable
        return arr[index];
    }
    /**
     * @function indexOf - function returns index of given element, -1 if element doesn't exist in array
     * @param o - given element to find index
     * @return int - index of element
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {  // checking if given element contains in array
                return i;
            }
        }
        return -1;  // returning -1 if element doesn't exist in array
    }
    /**
     * @function lastIndexOf - returning last index of given element, -1 if element doesn't exist in array
     * @param o - given element to find index
     * @return int - last index of element
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) { // starting from end to find last index
            if (arr[i] == o) {  // checking if given element contains in array
                return i;
            }
        }
        return -1;  // returning -1 if element doesn't exist in array
    }

    @Override
    public void sort() {

    }
    /**
     * @function checkIndex - checking if given index correct, throwing error if not
     * @param index - index to check
     */
    public void checkIndex(int index){
        if(index < 0 || index>=size) {  // checking if index acceptable
            throw new IndexOutOfBoundsException();  // throw error if not
        }
    }
    public void sortsrange(int monety,int ent){
        for(int i = monety; i<=ent; i ++){
            for (int j = monety; j < ent; j ++){
                if((int) arr[j] > (int) arr[j + 1]){
                    T temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                }
            }



    }
}