package dataStructure.linkedlist;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        Main.LinkedList linkedList1 = new Main.LinkedList();
        Main.LinkedList linkedList2 = new Main.LinkedList();

        for (int i = 1; i <= 5; i++) {
            linkedList2.insertNodeAtBegin(5 - i + 1);
        }

        for (int i = 1; i <= 3; i++) {
            linkedList1.insertNodeAtBegin(i);
        }

        linkedList1.root.next.next.next = linkedList2.root.next.next.next;

        int len1 = linkedList1.getLength();
        int len2 = linkedList2.getLength();

        Main.Node point = len1>len2 ? intersectionPoint(len1 - len2 , linkedList1.root , linkedList2.root)
                  : intersectionPoint(len2 - len1 , linkedList2.root , linkedList1.root);
        System.out.println(point.data);
    }

    private static Main.Node intersectionPoint(int i, Main.Node root1, Main.Node root2) {
        while(i>0){
            root1 = root1.next;
        }

        while(root2.next != null && root1.next !=null){
            if(root2 == root1)
                return root1;

            root1 = root1.next;
            root2 = root2.next;
        }
        return  null;
    }
}
