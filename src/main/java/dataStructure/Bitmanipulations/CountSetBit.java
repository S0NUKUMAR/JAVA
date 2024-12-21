package dataStructure.Bitmanipulations;

public class CountSetBit {
    public static void main(String[] args) {
        int i = countBit(6);
        System.out.println(i);
    }

    private static int countBit(int i) {
        if(i == 0 ) return 0 ;
        return 1 + countBit(i & (i-1));
    }
}
