package dataStructure.linkedlist;

import dataStructure.linkedlist.Main.*;

import java.util.HashSet;

public class DetectCycle {
    static boolean detect(Main.Node node){
        Main.Node slow = node;
        Main.Node fast = slow.next;

        while(slow.next!= null && fast.next!=null && fast.next.next!=null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    static boolean detectHashMapCycle(Node root){
        boolean flag = false;
        Node itr = root;
        HashSet<Node> hset = new HashSet<>();

        while(itr!=null){
            if(hset.contains(itr))
                return true;
            hset.add(itr);

            itr = itr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Main.LinkedList list = new Main.LinkedList();
        for (int i = 1; i <= 5; i++) {
            list.insertNodeAtBegin(i);
        }
        list.insertNodeAtBegin(5);

        list.root.next.next.next =list.root;
        System.out.println(detect(list.root));
        System.out.println(detectHashMapCycle(list.root));


    }
}
