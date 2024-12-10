package dataStructure.linkedlist;

import dataStructure.linkedlist.Main.*;


public class AddOneLinkedList {
    public static void addOneToList(Node head){
        Node prev  = null;
        Node itr = head;
        int carry = 1;
        while(itr!=null){
            int sum = carry + itr.data;
            carry = sum >=10 ? 1 : 0;
            itr.data = sum%10;
            prev = itr;
            itr = itr.next;
        }
        if (carry > 0){
            prev.next = new Node(carry);
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();


        list.insertNodeAtBegin(9);
        list.insertNodeAtBegin(9);

        list.root = ReverseLinkedList.reverseLinkedListRecursive(list.root);
        addOneToList(list.root);
        list.root = ReverseLinkedList.reverseLinkedListRecursive(list.root);
        list.printLinkedList();


    }
}