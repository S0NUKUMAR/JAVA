package dataStructure.linkedlist;

import dataStructure.linkedlist.Main.*;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void removeDuplicateSorted(Node node){
        Node itr = node;
        while(itr!=null){
            Node curr = itr;
            while(curr!=null && curr.data == itr.data){
                curr = curr.next;
            }
            itr.next = curr;
            itr = itr.next;
        }
    }

    public static void removeDuplicateUnSorted(Node node){
        Node itr = node;
        Node prev = null;
        Set<Integer> hset = new HashSet<>();
        while(itr!=null){
            if(hset.contains(itr.data)){
                prev.next = itr.next;
            }
            else{
                hset.add(itr.data);
                prev = itr;
            }
            itr = itr.next;
        }
    }

    public static void main(String[] args) {
        Main.LinkedList list = new Main.LinkedList();
        for (int i = 1; i <= 5; i++) {
            list.insertNodeAtBegin(i);
//            list.insertNodeAtBegin(i);
        }
        list.insertNodeAtBegin(1);

        list.printLinkedList();
        removeDuplicateSorted(list.root);
        removeDuplicateUnSorted(list.root);
        list.printLinkedList();
    }
}
