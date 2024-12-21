package dataStructure.linkedlist;

public class isPalindrome {
    static Main.Node left ;
    public static void main(String[] args) {
        Main.LinkedList list = new Main.LinkedList();
        list.insertNodeAtLast(1);
        list.insertNodeAtLast(2);
        list.insertNodeAtLast(3);
        list.insertNodeAtLast(3);
        list.insertNodeAtLast(1);

        list.printLinkedList();

        boolean val = isPalindromeCheck(list.root , true);
        System.out.println(val);
    }

    private static boolean isPalindromeCheck(Main.Node right , boolean flag ) {
        if(flag)
            left = right;

        if (right == null)
            return true;

        boolean isp = isPalindromeCheck(right.next , false);
        if (isp == false)
            return false;

        boolean isp1 = (right.data == left.data);

        left = left.next;

        return isp1;
    }


}
