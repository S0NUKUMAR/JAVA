package dataStructure.BinarySearch;

public class FindSquareRoot {
    public static void main(String[] args) {
        System.out.println(findRoot(12));
    }

    private static int findRoot(int i) {
        // the square root of `x` cannot be more than `x/2` for `x > 1`
        int left = 1;
        int right = i/2;
        int result = 0;

        while(left <= right){
            int mid = left + (right - left)/2;
            int tempRoot = mid*mid;
            if(tempRoot== i){
                return mid;
            }else if(tempRoot < i) {
                left = mid + 1;

                // update result since we need a floor
                result = mid;
            }else{
                right = mid  - 1;
            }
        }
        return result;
    }
}
