package dataStructure.linkedlist;

public class MiddleNodeLinkedList {
    public static void main(String[] args) {
        Main.LinkedList list = new Main.LinkedList();
        for(int i = 1; i <= 4; i++) {
            list.insertNodeAtBegin(i);
        }

        Main.Node middle = middleNode(list.root);
        System.out.println(middle.data);
    }

    public static Main.Node middleNode(Main.Node root) {
        Main.Node slow = root , fast = root.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
