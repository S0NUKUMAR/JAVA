package dataStructure.Array;

public class MergeSort {
    public static void main(String[] args) {
        int []a = new int[5];

        for(int i =0 ; i < 5 ; i++){
            a[i]= 5 - i;
        }
        for(int i =0 ; i < 5 ; i++){
            System.out.print(a[i]);
        }
        System.out.println();

        mergeSort(a);

        for(int i =0 ; i < 5 ; i++){
            System.out.print(a[i]);
        }
    }

    private static void mergeSort(int[] a) {
        mergeSortHelper(a , 0 , a.length - 1);
    }

    private static void mergeSortHelper(int[] a, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            mergeSortHelper(a, l, mid);
            mergeSortHelper(a, mid + 1, r);

            mergeArray(a, l, mid, r);
        }
    }

    private static void mergeArray(int[] a, int l, int mid, int r) {
        int firstHalf = mid - l + 1;
        int secondHalf = r - mid;
        //creating temp array
        int leftArray[] = new int[firstHalf];
        int rightArray[] = new int[secondHalf];

        for(int i = 0 ; i<firstHalf;i++) leftArray[i]=a[l+i];
        for(int j = 0 ; j<secondHalf;j++) rightArray[j]=a[mid + j + 1];

        int i,j,k = l;
        i = j = 0 ;

        while (i<firstHalf && j<secondHalf){
            a[k++] = leftArray[i] < rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        while (i< firstHalf) a[k++] =leftArray[i++];
        while (j< secondHalf) a[k++] =rightArray[j++];

    }
}
