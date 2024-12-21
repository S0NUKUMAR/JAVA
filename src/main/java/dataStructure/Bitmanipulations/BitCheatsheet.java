package dataStructure.Bitmanipulations;

public class BitCheatsheet {
    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++)
            System.out.printf("%d : %b : %d \n " ,i , CheckPowerOfTwo(i) , MSBSetBit(i));
    }

    private static int MSBSetBit(int i) {
        i|= i >> 1;
        i|= i >> 4;
        i|= i >> 8;
        i|= i >> 16;

        i = i + 1;

        return i >> 1;
    }

    private static boolean CheckPowerOfTwo(int i) {
        // first check is for 0 value
        // second is the actual logic to see the number is power of two, always remember the number and the number smalled than it will be inverted.
        // example : i = 4 binary (100) ; i - 1 = 3 binary (011)
        // take AND operation will make it all zero
        return (i!=0) && ((i & (i-1)) == 0);
    }


}
