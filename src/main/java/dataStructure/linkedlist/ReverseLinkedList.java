package dataStructure.linkedlist;


import dataStructure.linkedlist.Main.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head) {
            Node prev , next  , curr ;
            curr = head;
            prev = null;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            return prev;
        }

    public static Node reverseLinkedListRecursive(Node head){
            Node first;

            if(head == null || head.next == null){
                return head;
            }

            first = reverseLinkedListRecursive(head.next);
            head.next.next = head;
            head.next = null;

            return first;
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

//        linkedList.root = reverseLinkedList(linkedList.root);
        linkedList.root = reverseLinkedListRecursive(linkedList.root);
        linkedList.printLinkedList();

    }
}