package dataStructure.BinarySearch;

public class findNoOfRotation {
    public static void main(String[] args) {
        int array[] = new int[]{8, 9, 10, 2, 5, 6};
        System.out.println(findIndex(array));
    }

    private static int findIndex(int[] array) {
        int left = 0;
        int n = array.length;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;
            if(array[left] <=array[right]){
                return left;
            }
            if (array[mid] <= array[next] && array[mid] <= array[prev]) {
                return mid;
            } else if (array[left] <= array[mid]) {
                left = mid + 1;
            } else if (array[right] >= array[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
