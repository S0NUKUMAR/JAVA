package dataStructure.Recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        boolean[] visited = new  boolean[array.length];
        findAllPermutation(array,new ArrayList<Integer>(),list , visited);
        System.out.println(list.toString());

        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        permutationBySwaping(array, 0 , list1);
        System.out.println(list1.toString());
    }

    private static void permutationBySwaping(int[] array, int idx, ArrayList<ArrayList<Integer>> list1) {
        if(idx == array.length){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j : array) {
                temp.add(j);
            }
            list1.add(temp);
            return;
        }


        for(int i = idx ; i < array.length ; i++){
            swap(array,i,idx);
            permutationBySwaping(array,idx + 1 , list1);
            swap(array,i,idx);
        }
    }

    public static void swap(int[] array , int i , int j){
        int temp = array[j];
        array[j]=array[i];
        array[i] = temp;
    }

    private static void findAllPermutation(int[] array, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list , boolean[] visited) {
        if(temp.size() == array.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < array.length; i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(array[i]);
                findAllPermutation(array,temp,list,visited);
                visited[i] = false;
                temp.remove(temp.size() -1);
            }
        }
    }
}
