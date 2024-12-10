package dataStructure.linkedlist;

public class AdditionOfTwoNumbers {
    public static void main(String[] args) {
        Main.LinkedList linkedList1 = new Main.LinkedList();
        Main.LinkedList linkedList2 = new Main.LinkedList();

        for (int i = 1; i <= 5; i++) {
            linkedList1.insertNodeAtBegin(5 - i + 1);
            linkedList2.insertNodeAtBegin(5 - i + 1);

        }
        linkedList1.printLinkedList();
        linkedList2.printLinkedList();
        linkedList1.root = ReverseLinkedList.reverseLinkedListRecursive(linkedList1.root);
        linkedList2.root = ReverseLinkedList.reverseLinkedListRecursive(linkedList2.root);
     ;

        additionTwoNumber(linkedList1.root , linkedList2.root);

        linkedList1.root = ReverseLinkedList.reverseLinkedListRecursive(linkedList1.root);
        linkedList1.printLinkedList();
    }

    private static void additionTwoNumber(Main.Node node1, Main.Node node2) {
        int sum , carry = 0 ;
        Main.Node prev = null;
        while(node1!=null && node2!=null){
            sum = carry + node1.data + node2.data;
            carry =  sum >=10 ? sum/10 : 0 ;
            sum = sum%10;
            prev = node1;
            node1.data = sum;
            node1 = node1.next;
            node2 = node2.next;
        }

        if(node2!=null) prev.next = node2;
        node1 = prev.next;
        while(node1!=null){
            sum = carry + node1.data + node2.data;
            carry =  sum >=10 ? sum/10 : 0 ;
            sum = sum%10;
            prev = node1;
            node1.data = sum;
            node1 = node1.next;
        }
        if(carry>0){
            prev.next = new Main.Node(carry);
        }
    }
}
