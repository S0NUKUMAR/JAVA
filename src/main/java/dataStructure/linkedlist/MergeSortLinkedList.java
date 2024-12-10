package dataStructure.linkedlist;

import dataStructure.linkedlist.Main.*;
import static dataStructure.linkedlist.MiddleNodeLinkedList.middleNode;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i = 0 ; i<10 ; i++)
            list.insertNodeAtBegin(i+1);

        list.printLinkedList();

        list.root = mergeSortLinkedList(list.root);

        list.printLinkedList();
    }

    private static Node mergeSortLinkedList(Node root) {
        if(root.next == null)
            return root;

        Node middleNode = middleNode(root);
        Node middleNext = middleNode.next;

        middleNode.next = null;

        Node firstHalf = mergeSortLinkedList(root);
        Node secondHalf = mergeSortLinkedList(middleNext);

        return  mergeLinkedList(firstHalf,secondHalf);

    }

    private static Node mergeLinkedList(Node firstHalf, Node secondHalf) {
            Node merged = new Node(-123);
            Node temp = merged;

            while (firstHalf!=null && secondHalf!=null){
                if(firstHalf.data < secondHalf.data){
                    temp.next = firstHalf;
                    firstHalf = firstHalf.next;
                }
                else {
                    temp.next = secondHalf;
                    secondHalf = secondHalf.next;
                }
                temp = temp.next;
            }


            while(firstHalf!=null){
                temp.next = firstHalf;
                firstHalf = firstHalf.next;
                temp = temp.next;
            }

            while(secondHalf!=null) {
                    temp.next = secondHalf;
                    secondHalf = secondHalf.next;
                    temp = temp.next;
            }

            return merged.next;
    }
}
