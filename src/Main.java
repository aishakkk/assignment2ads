import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //testArrayList();
        testLinkedList();
    }

    public static void testArrayList() {
        Scanner sc = new Scanner(System.in);
        MyArrayList List = new MyArrayList();
        System.out.println("Let's start testing with MyArrayList of integers\n" +
                "Add some values in array. Enter '-1' to stop typing");
        int item;
        while (true) {
            item = sc.nextInt();
            if (item == -1) break;
            List.add(item);
        }
        System.out.print("Your array: ");
        List.display();
        System.out.println("Size of array: " + List.size());

        System.out.print("\nLet's add an element at specific index. Enter element and index separated by space: ");
        item = sc.nextInt();
        int index = sc.nextInt();
        List.add(item, index);
        System.out.print("Your array: ");
        List.display();

        System.out.print("\nLet's delete your element with index. Enter index: ");
        index = sc.nextInt();
        System.out.println("You deleted - " + List.remove(index));
        System.out.print("Your array: ");
        List.display();

        System.out.print("\nLet's delete your element without knowing index. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element was deleted - " + List.remove((Object) item));
        System.out.print("Your array: ");
        List.display();

        System.out.print("\nNow let's find out if the element you entered is in the array. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element is in array - " + List.contains((item)));
        System.out.print("Your array: ");
        List.display();

        System.out.print("\nAnd now let's find out the first index of the occurrence of the element you entered in the array. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element's index - " + List.indexOf(item));
        System.out.print("Your array: ");
        List.display();

        System.out.print("\nNow let's find out the last index of the occurrence of the element you entered in the array. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element's last index - " + List.lastIndexOf(item));
        System.out.print("Your array: ");
        List.display();

        System.out.print("\nLet's try to find out your element with index. Enter your index: ");
        index = sc.nextInt();
        System.out.println("Your element is - " + List.get(index));
        System.out.print("Your array: ");
        List.display();
    }

    public static void testLinkedList() {
        Scanner sc = new Scanner(System.in);
        MyLinkedList linkedList = new MyLinkedList<Integer>();
        System.out.println("et's start testing with MyLinkedList of integers\n" +
                "Add some values in array. Enter '-1' to stop typing");
        int item;
        while (true) {
            item = sc.nextInt();
            if (item == -1) break;
            linkedList.add(item);
        }
        System.out.print("Your array: ");
        linkedList.display();
        System.out.println("Size of array: " + linkedList.size());

        System.out.print("\nLet's add an element at specific index. Enter element and index separated by space: ");
        item = sc.nextInt();
        int index = sc.nextInt();
        linkedList.add(item, index);
        System.out.print("Your array: ");
        linkedList.display();

        System.out.print("\nLet's delete your element with index. Enter index: ");
        index = sc.nextInt();
        System.out.println("You deleted - " + linkedList.remove(index));
        System.out.print("Your array: ");
        linkedList.display();

        System.out.print("\nLet's delete your element without knowing index. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element was deleted - " + linkedList.remove((Object) item));
        System.out.print("Your array: ");
        linkedList.display();

        System.out.print("\nNow let's find out if the element you entered is in the array. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element is in array - " + linkedList.contains((item)));
        System.out.print("Your array: ");
        linkedList.display();

        System.out.print("\nAnd now let's find out the first index of the occurrence of the element you entered in the array. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element's index - " + linkedList.indexOf(item));
        System.out.print("Your array: ");
        linkedList.display();

        System.out.print("\nNow let's find out the last index of the occurrence of the element you entered in the array. Enter your element: ");
        item = sc.nextInt();
        System.out.println("Your element's last index - " + linkedList.lastIndexOf(item));
        System.out.print("Your array: ");
        linkedList.display();

        System.out.print("\nLet's try to find out your element with index. Enter your index: ");
        index = sc.nextInt();
        System.out.println("Your element is - " + linkedList.get(index));
        System.out.print("Your array: ");
        linkedList.display();
    }
}