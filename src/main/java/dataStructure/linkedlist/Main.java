package dataStructure.linkedlist;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class LinkedList {
        Node root ;
        LinkedList(){
            root = null;
        }

        void insertNodeAtLast(int data){
            Node newNode = new Node(data);

            if(root == null){
                root = newNode;
                return;
            }

            Node itr = root ;

            while(itr.next !=null){
                itr = itr.next;
            }

            itr.next = newNode;
            return;
        }

        void printLinkedList(){
            Node itr = root;
            while (itr!= null){
                System.out.print(itr.data + " ");
                itr = itr.next;
            }
            System.out.println();
        }

        void insertNodeAtBegin(int data){
            Node newNode = new Node(data);
            if(root == null){
                root = newNode;
                return;
            }

            newNode.next = root ;
            root = newNode;
            return;
        }

        void insertAtPosition(int data , int index){
            Node newNode = new Node(data);
            Node itr = root ;
            int idx = 1;
            while(itr !=null) {
                if (index == idx) {
                    newNode.next = itr.next;
                    itr.next = newNode;
                    break;
                }
                itr = itr.next;
                idx++;
            }
        }

        int getLength(){
            Node itr = root;
            int length = 0 ;
            while (itr!= null){
                length++;
                itr = itr.next;
            }
            return length;
        }

    }
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 5; i++) {
           linkedList.insertNodeAtBegin(i);
        }


        linkedList.printLinkedList();

     }
}