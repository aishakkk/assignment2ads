# Assignment 2 *from best student to best teacher*
## 💨 MyArrayList.java
### 💬 display()
> **Task:** function print elements of array in console
```java
public void display() {
  for (int i = 0; i < size; i++) {
    System.out.print(arr[i] + " ");
  }
  System.out.println();
}
```
### 💬 increaseLen()
> **Task:** function increase size of array
```java
private void increaseLen() {
  T[] newArr = (T[]) new Object[arr.length*2];
  for (int i = 0; i < arr.length; i++) {
    newArr[i] = arr[i];
  }
  arr = newArr;
}
```
### 💬 size()
> **Task:** function returns size of array as integer
```java
@Override
public int size() {
  return size;
}
```
### 💬 contains(Object o)
> **Task:** function check is array have given element or not
```java
@Override
public boolean contains(Object o) {
  for (int i = 0; i < size; i++) {
    if (arr[i] == o) {
      return true;
    }
  }
  return false;
}
```
### 💬 add(Object item)
> **Task:** function adding a new element to array at the end
```java
@Override
public void add(Object item) {
  if (size == arr.length) {
    increaseLen();
  }
  arr[size++] = (T) item;
}
```
### 💬 add(Object item, int index)
> **Task:** function adding a new element to specific index in array
```java
@Override
public void add(Object item, int index) {
  checkIndex(index);
  if (size == arr.length) {
    increaseLen();
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
```
### 💬 remove(Object item)
> **Task:** function remove item from array
```java
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
```
### 💬 remove(int index)
> **Task:** function remove item from array in specific index and return item which was removed
```java
@Override
public Object remove(int index) {
  checkIndex(index);
  T removed = arr[index];
  for(int i = index + 1; i < size; i++) {
    arr[i-1] = arr[i];
  }
  size--;
  return removed;
}
```
### 💬 clear()
> **Task:** function clear array by creating new empty array
```java
@Override
public void clear() {
  this.arr = (T[]) new Object[5];
  this.size = 5;
}
```
### 💬 get(int index)
> **Task:** function returns element from array in specific index
```java
@Override
public Object get(int index) {
  checkIndex(index);
  return arr[index];
}
```
### 💬 indexOf(Object o)
> **Task:** function returns index of given element, -1 if element doesn't exist in array
```java
@Override
public int indexOf(Object o) {
  for (int i = 0; i < size; i++) {
    if (arr[i] == o) {
      return i;
    }
  }
  return -1;
}
```
### 💬 lastIndexOf(Object o)
> **Task:** returning last index of given element, -1 if element doesn't exist in array
```java
@Override
public int lastIndexOf(Object o) {
  for (int i = size - 1; i >= 0; i--) {
    if (arr[i] == o) {
      return i;
    }
  }
  return -1;
}
```
### 💬 ~~sort()~~
> **Task:** function sort array
```java
@Override
public void sort() {
  return;
}
```
### 💬 checkIndex(int index)
> **Task:** checking if given index correct, throwing error if not
```java
public void checkIndex(int index){
  if(index < 0 || index>=size) {
    throw new IndexOutOfBoundsException();
  }
}
```

## 💨 MyLinkedList.java
### 💬 isEmpty()
> **Task:** function check is linked list empty or not
```java
public boolean isEmpty() {
  return head == null;
}
```
### 💬 display()
> **Task:** function print all elements of linked list in console
```java
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
```
### 💬 size()
> **Task:** function returns size of linked list
```java
@Override
public int size() {
  return size;
}
```
### 💬 contains(Object o)
> **Task:** function check is list have given element
```java
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
```
### 💬 add(Object item)
> **Task:** function add element to linked list at end
```java
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
```
### 💬 add(Object item, int index)
> **Task:** function add element to linked list at specific index
```java
@Override
public void add(Object item, int index) {
  checkIndex(index);
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
```
### 💬 remove(Object item)
> **Task:** function delete element in linked list
```java
@Override
public boolean remove(Object item) {
  Node<T> newNode = new Node<T>((T) item, null, null);
  if (head.val == newNode.val) {
    head = head.next;
    head.prev = null;
    size--;
    return true;
  }
  Node<T> ptr = head.next;
  while (ptr != null) {
    if (ptr.val == newNode.val) {
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
```
### 💬 remove(int index)
> **Task:** function delete element at specific index in linked list
```java
@Override
public Object remove(int index) {
  checkIndex(index);
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
```
### 💬 clear()
> **Task:** function clear all linked list by creating new
```java
@Override
public void clear() {
  this.head = null;
  this.tail = null;
  size = 0;
}
```
### 💬 get(int index)
> **Task:** function returns element in linked list by specific index
```java
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
```
### 💬 indexOf(Object o)
> **Task:** function returns index of given element in linked list
```java
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
```
### 💬 lastIndexOf(Object o)
> **Task:** function returns last index of given element in linked list
```java
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
```
### 💬 ~~sort()~~
> **Task:** function sort array
```java
@Override
public void sort() {
  return;
}
```
### 💬 checkIndex(int index)
> **Task:** checking if given index correct, throwing error if not
```java
public void checkIndex(int index){
  if(index < 0 || index>=size) {
    throw new IndexOutOfBoundsException();
  }
}
```
