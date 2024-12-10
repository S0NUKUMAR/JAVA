package dataStructure.BinarySearch;


public class BinarySearch {
    public static void main(String[] args) {
        int array[]  = new int[10];

        for(int i = 0 ; i < 10 ; i++){
            array[i] = i+1;
        }

        System.out.println(binarySearchDemo(array,10));
        System.out.println(binarySearchDemo(array,0));

    }

    private static int binarySearchDemo(int[] array, int i) {
        int left =  0 ;
        int right = array.length;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == i)
                return mid;
            else if(array[mid] > i){
                right = mid -1;
            }
            else left = mid + 1;
        }
        return -1;
    }


    private static int binarySearchRecursion(int[] array, int i, int left, int right) {
        if(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == i)
                return mid;
            else if(array[mid] > i){
                return binarySearchRecursion(array,i,left,mid-1);
            }
            else return binarySearchRecursion(array,i,mid+1,right);
        }
        return -1;
    }
}
