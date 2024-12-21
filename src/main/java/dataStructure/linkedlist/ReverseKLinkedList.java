package dataStructure.linkedlist;

import dataStructure.linkedlist.Main.*;

public class ReverseKLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for(int i =0 ; i<10; i++){
            list.insertNodeAtBegin(10-i);
        }

        list.printLinkedList();

        list.root = reverseKlinkNode(list.root,4);
        list.printLinkedList();
    }

    private static Node reverseKlinkNode(Node root, int i) {
        if(root == null)
            return  root;

        int count = 0;
        Node curr , next , prev ;
        next = prev = null;
        curr = root;


        while(count < i && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count++;
        }

        if(next!=null){
            root.next = reverseKlinkNode(next,i);
        }

        return prev;
    }
}
