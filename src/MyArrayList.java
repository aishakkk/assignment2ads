public class MyArrayList<T> implements MyList{
    private T[] arr;
    private int size;
    public MyArrayList() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }

    private void increaseLength() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object item) {
        if (size == arr.length){
            T[] newArr = (T[]) new Object[arr.length*2];
            for (int i=0; i< arr.length; i++){
                newArr[i] = arr[i];
            }
            arr=newArr;
        }
        arr[size++]=(T) item;
    }

    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        if (size == arr.length) {
            increaseLength();
        }
        T[] newArr = (T[]) new Object[arr.length];
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

    @Override
    public boolean remove(Object item) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) {
                remove(i);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        for(int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i];
        }
        size--;
        return null;
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 5;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}