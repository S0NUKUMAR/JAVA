package dataStructure.BinarySearch;
/*
    As per problem constraints, identical elements appear in pairs in the array,
    and there cannot be more than two consecutive occurrences of any element.
    So, there must be a single occurrence of the odd element somewhere in the array.

    If we carefully observe, each pair of the element before the odd occurring element has the first occurrence at an even index and the second occurrence at an odd index.
    And, each pair of the element after the odd occurrence has the first occurrence at the odd index and the second occurrence at the even index.

    We can use the above observation to determine which side of the mid-index the odd occurring element lies. Now, two cases arise:

        1.The mid-index is odd: If the element before the mid-index is the same as the middle element,
        * the odd element lies on the right side; otherwise, it lies on the left side.
        2.The mid-index is even: If the element next to the mid-index is the same as the middle element,
        * the odd element lies on the right side; otherwise, it lies on the left side.

*/
public class OddOccurringElement {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 3, 3, 2, 2, 4, 4, 3, 1, 1 };
        System.out.println("The odd occurring element is " + nums[findOddOccuring(nums)]);
    }

    private static int findOddOccuring(int[] nums) {
       int left = 0 ;
       int right = nums.length -1 ;

       while(left<right){
           int mid = left +(right - left)/2;

           if(mid%2 == 0){
               if(nums[mid+1]==nums[mid]){
                   left = mid + 2;
               }else
                   right = mid ;
           } else{
               if(nums[mid-1]==nums[mid]){
                   left = mid +1;
               }else
                   right = mid -1;
           }
       }
       return left;
    }
}
