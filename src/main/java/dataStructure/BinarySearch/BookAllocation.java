package dataStructure.BinarySearch;

public class BookAllocation {
    public static void main(String[] args) {
        /*N = 4, pages[] = {12, 34, 67, 90}, M = 2*/
        int books[] = new int[]{12, 34, 67, 90};
        int student = 2;

        minPages(books,student);
    }

    private static void minPages(int[] books, int student) {
        int maxi = Integer.MIN_VALUE;
        int totalPages = 0 ;
        int result = 0;

        for(int book : books){
            maxi = book > maxi ? book : maxi;
            totalPages+=book;
        }

        int left = maxi;
        int right = totalPages;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(mid,books,student)){
                result = mid ;
                right = mid -1 ;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean isPossible(int mid, int[] books, int student) {
        int noOfStudent = 1;
        int pages = 0 ;
        for(int book : books){
            pages+=book;
            if(pages>mid){
                noOfStudent+=1;
                pages = book;
            }
        }
        return noOfStudent <= student;
    }
}
