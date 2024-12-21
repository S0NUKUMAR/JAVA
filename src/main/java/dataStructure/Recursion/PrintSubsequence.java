package dataStructure.Recursion;

import java.util.ArrayList;

public class PrintSubsequence {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        printSubsequence(array,0 ,new ArrayList<>(),list);
        System.out.println(list.toString());

    }


    private static void printSubsequence(int[] array , int idx, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list) {

        //step 3: final answer added if index is equal to size
        if(idx == array.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        //step 1: inclusion of the element
        temp.add(array[idx]);
        printSubsequence(array , idx + 1,temp,list);

        //step 2: exclusion of the element
        temp.remove(temp.size() -1);
        printSubsequence(array , idx + 1 ,temp,list);
    }


}
