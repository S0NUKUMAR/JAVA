package dataStructure.Recursion;

import java.util.ArrayList;

public class SubsequenceSum {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,2};

        // multiple selection is allowed
        ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
        int sum = 3;
        findSubsequenceSumK(array,0,sum,new ArrayList<>(),list);
        System.out.println(list.toString());

//        ArrayList<ArrayList<Integer>>  list1 = new ArrayList<>();
//        sum = 3;
//        findSubsequenceSumKNonRepeat(array,0,sum,new ArrayList<>(),list1);
//        System.out.println(list1.toString());
//
//        array = new int[]{10, 1, 2, 7, 6, 1, 5};
//        Arrays.sort(array);
//        ArrayList<ArrayList<Integer>>  list2 = new ArrayList<>();
//        sum =8;
//        findUniqueSubsequenceSumK(array,0,sum,new ArrayList<>(),list2);
//        System.out.println(list2.toString());
//
//
//        array = new int[]{1,2};
//        ArrayList<Integer>  list3 = new ArrayList<>();
//        findSumofSubsets(array,0, 0,list3);
//        System.out.println(list3.toString());
    }

    private static void findSumofSubsets(int[] array, int idx, int sum , ArrayList<Integer> list3) {

        //step 3: final answer added if index is equal to size
        if(idx == array.length){
            list3.add(sum);
            return;
        }


        //step 1: inclusion of the element
        sum += array[idx];
        findSumofSubsets(array, idx+1, sum, list3);

        //step 2: exclusion of the element
        sum -= array[idx];
        findSumofSubsets(array,idx +1 , sum,list3);

    }

    private static void findUniqueSubsequenceSumK(int[] array, int idx, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list2) {
        //step 3: final answer added if sum is Zero
        if(sum == 0){
            list2.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx ; i < array.length ; i++){
            if( i > idx && array[i] == array[i -1]) continue;
            if(array[i]>sum) break;

            temp.add(array[i]);
            findUniqueSubsequenceSumK(array,i + 1,sum - array[i],temp,list2);
            temp.remove(temp.size() -1);
        }
    }

    private static void findSubsequenceSumK(int[] array, int idx, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list) {
        //step 3: final answer added if index is equal to size & sum is Zero
        if(idx == array.length) {
            if (sum == 0) {
                list.add(new ArrayList<>(temp));
                return;
            }
            return ;
        }

        //same index is used again , idx is not incremented
        if(array[idx]<=sum) {
            //step 1: inclusion of the element
            sum -= array[idx];
            temp.add(array[idx]);
            findSubsequenceSumK(array, idx, sum, temp, list);

            //step 2: exclusion of the element
            sum += array[idx];
            temp.remove(temp.size() - 1);
        }
        findSubsequenceSumK(array,idx +1 , sum, temp,list);

    }


    private static void findSubsequenceSumKNonRepeat(int[] array, int idx, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list) {

        //step 3: final answer added if index is equal to size & sum is Zero
        if(idx == array.length) {
            if (sum == 0) {
                list.add(new ArrayList<>(temp));
                return;
            }
            return ;
        }

            //step 1: inclusion of the element
            sum -= array[idx];
            temp.add(array[idx]);
            findSubsequenceSumKNonRepeat(array, idx+1, sum, temp, list);

            //step 2: exclusion of the element
            sum += array[idx];
            temp.remove(temp.size() - 1);
            findSubsequenceSumKNonRepeat(array,idx +1 , sum, temp,list);

    }




}
