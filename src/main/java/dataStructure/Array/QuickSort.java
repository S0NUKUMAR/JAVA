package dataStructure.Array;

public class QuickSort {
    public static void main(String[] args) {
        int []a = new int[5];

        for(int i =0 ; i < 5 ; i++){
            a[i]= 5 - i;
        }
        for(int i =0 ; i < 5 ; i++){
            System.out.print(a[i]);
        }
        System.out.println();

        quickSort(a);
        for(int i =0 ; i < 5 ; i++){
            System.out.print(a[i]);
        }
    }

    static void quickSort(int[] a) {
        quickSortHelper(a,0,a.length -1);
    }
    public static void quickSortHelper(int[] a, int l, int r) {
        if(l < r){
            int pivotIndex = partition(a,l,r);
            quickSortHelper(a,l,pivotIndex - 1);
            quickSortHelper(a,pivotIndex + 1 ,r);
            }
    }

    public static int partition(int[] a,int l, int r) {
        int pivot = a[r];
        int i = l - 1;

        for(int j = l ; j< r ; j++){
            if(a[j]<pivot){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i + 1, r);
        return (i + 1);
    }

    public static void swap(int[] a, int i, int r) {
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
    }
}