package dataStructure.BinarySearch;

public class SmallestMissingNumber {
    public static void main(String[] args) {
        int array[] = new int[]{ 0, 1, 2, 3, 4, 5, 6 };
        System.out.println(findMissingNumberIndex(array));

    }

    private static int findMissingNumberIndex(int[] array) {
        int left = 0 ;
        int right = array.length -1 ;

        while (left <= right){
            int mid = left + (right - left)/2;

            // if the mid-index matches with its value, then the mismatch
            // lies on the right half
            if(array[mid]==mid){
                left = mid  + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}
