package dataStructure.BinarySearch;

public class findFirstLastIndex {
    public static void main(String[] args) {
        int array[] = new int[]{1,2,2,3,3,3,3,3,4,4,4,5,5,5,6,6,7,7};
        //left and right index
        System.out.printf("first Index: %d\nlastIndex: %d\n" ,findLIndex(array , 3) ,  findRIndex(array , 3));

        //total count of the target
        System.out.printf("totalNumber of times:%d " ,findRIndex(array , 5) -  findLIndex(array , 5) + 1);

    }

    private static int findLIndex(int[] array  , int i ) {
        int left =  0 ;
        int right = array.length  - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid]>=i)
                right = mid - 1;
            else
                left = mid + 1 ;
        }
        return left;
    }

    private static int findRIndex(int[] array  , int i ) {
        int left =  0 ;
        int right = array.length  - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid]<=i)
                left = mid + 1;
            else
                right = mid - 1 ;
        }
        return right;
    }
}
